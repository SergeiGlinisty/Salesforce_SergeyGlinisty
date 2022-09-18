package tests;

import modals.NewAccountModal;
import modals.NewCaseModal;
import modals.NewOpportunityModal;
import models.Case;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.accounts.AccountDetailsPage;
import pages.accounts.AccountsPage;
import pages.cases.CasePage;
import pages.cases.CasesDetailsPage;
import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;

import static constants.Constants.NewLead.DESCRIPTION;
import static constants.Constants.NewLead.TITLE;
import static enums.CaseOrigin.TWITTER;
import static enums.Priority.HIGH;
import static enums.Priority.MEDIUM;
import static enums.Status.CLOSED;
import static enums.Status.OPEN;

public class CaseTest extends BaseTest {

    @BeforeClass
    public void initialise() {
        opportunitiesPage = new OpportunitiesPage(driver);
        opportunitiesDetailsPage = new OpportunitiesDetailsPage(driver);
        newOpportunityModal = new NewOpportunityModal(driver);
        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        newAccountModal = new NewAccountModal(driver);
        casePage = new CasePage(driver);
        casesDetailsPage = new CasesDetailsPage(driver);
        newCaseModal = new NewCaseModal(driver);

    }

    @AfterMethod(onlyForGroups = {"CreatingNewCase", "UpdatingCase"})
    public void delete() {

        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickEntityDropdownIcon();
        casePage.clickDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntity();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickEntityDropdownIcon();
        casePage.clickDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntity();
    }


    @Test(description = "Create a new Case test", groups = {"Smoke", "CreatingNewCase"})
    public void createNewCase() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickNewButton();
        newCaseModal.waitForPageLoaded();


        Case testCase = Case.builder()
                .caseOrigin(TWITTER)
                .status(OPEN)
                .priority(HIGH)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();

        Case expectedCase = Case.builder()
                .status(OPEN)
                .priority(HIGH)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();

        newCaseModal.fillForm(testCase);
        newCaseModal.clickSaveButton();
        Assert.assertTrue(casePage.isPopupPresent());
        Assert.assertEquals(expectedCase, casesDetailsPage.getCaseInfo());


    }

    @Test(description = "Checking the update Case test", groups = {"Smoke", "UpdatingCase"})
    public void positiveUpdateCase() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickNewButton();
        newCaseModal.waitForPageLoaded();


        Case testCase = Case.builder()
                .caseOrigin(TWITTER)
                .status(OPEN)
                .priority(HIGH)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();


        newCaseModal.fillForm(testCase);
        newCaseModal.clickSaveButton();
        homePage.openCaseTab();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.waitForCheckboxeLoaded();
        casePage.clickCheckboxIcon();
        casePage.clickUpdateCaseButton();

        Case UpdatingTestCase = Case.builder()
                .status(CLOSED)
                .priority(MEDIUM)
                .build();

        Case expectedUpdatingCase = Case.builder()
                .status(CLOSED)
                .priority(MEDIUM)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();

        newCaseModal.fillFormUpdate(UpdatingTestCase);
        casePage.clickSaveButtonToUpdate();
        Assert.assertTrue(casePage.isPopupPresentPositiveUpdate());
        casePage.clickCase();
        Assert.assertEquals(expectedUpdatingCase, casesDetailsPage.getCaseInfo());
    }

    @Test(description = "Checking the delete Case test", groups = {"Smoke"})
    public void deleteCase() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickNewButton();
        newCaseModal.waitForPageLoaded();


        Case testCase = Case.builder()
                .caseOrigin(TWITTER)
                .status(OPEN)
                .priority(HIGH)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();


        newCaseModal.fillForm(testCase);
        newCaseModal.clickSaveButton();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickEntityDropdownIcon();
        casePage.clickDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntity();
        casePage.waitForDeleteText();
        Assert.assertTrue(casePage.isPopupPresentDelete());
        Assert.assertTrue(casePage.isEmptyText());
    }

    @Test(description = "negative Update test", groups = {"Negative"})
    public void negativeUpdateCase() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickUpdateCaseButton();
        Assert.assertTrue(casePage.isPopupPresentNegativeUpdate());
    }

}

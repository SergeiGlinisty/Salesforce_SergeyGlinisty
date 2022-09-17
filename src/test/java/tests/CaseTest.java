package tests;

import com.github.javafaker.Faker;
import enums.Status;
import modals.NewCaseModal;
import modals.NewOpportunityModal;
import models.Case;
import models.Opportunity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.cases.CasePage;
import pages.cases.CasesDetailsPage;
import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;

import static constants.Constants.*;
import static constants.Constants.DATA;
import static constants.Constants.NewLead.DESCRIPTION;
import static constants.Constants.NewLead.TITLE;
import static enums.CaseOrigin.TWITTER;
import static enums.Priority.HIGH;
import static enums.Priority.MEDIUM;
import static enums.Stage.QUALIFICATION;
import static enums.Status.CLOSED;
import static enums.Status.OPEN;

public class CaseTest extends BaseTest {

    @BeforeClass
    public void initialise() {

        casePage = new CasePage(driver);
        casesDetailsPage = new CasesDetailsPage(driver);
        newCaseModal = new NewCaseModal(driver);


    }

    @Test
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

    @Test
    public void positiveUpdateCase() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickCheckboxIcon();
        casePage.clickUpdateCaseButton();

        Case testCase = Case.builder()
                .status(CLOSED)
                .priority(MEDIUM)
                .build();

        Case expectedCase = Case.builder()
                .status(CLOSED)
                .priority(MEDIUM)
                .subject(TITLE)
                .description(DESCRIPTION)
                .build();

        newCaseModal.fillFormUpdate(testCase);
        casePage.clickSaveButtonToUpdate();
        Assert.assertTrue(casePage.isPopupPresentPositiveUpdate());
        casePage.clickCase();
        Assert.assertEquals(expectedCase, casesDetailsPage.getCaseInfo());
    }

    @Test
    public void deleteCase(){

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.clickEntityDropdownIcon();
        casePage.clickDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntity();
        casePage.waitForDeleteText();
        Assert.assertTrue(casePage.isPopupPresentDelete());
    }

    @Test
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

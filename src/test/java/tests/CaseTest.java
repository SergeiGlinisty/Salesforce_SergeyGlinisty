package tests;

import models.Case;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static constants.Constants.NewLead.DESCRIPTION;
import static constants.Constants.NewLead.TITLE;
import static enums.CaseOrigin.TWITTER;
import static enums.Priority.HIGH;
import static enums.Priority.MEDIUM;
import static enums.Status.CLOSED;
import static enums.Status.OPEN;

public class CaseTest extends BaseTest {

    @AfterMethod(onlyForGroups = {"CreatingNewCase", "UpdatingCase"})
    public void deleteCase() throws InterruptedException {

        homePage.openCaseTab();
        casePage.waitForPageLoaded();
        casePage.waitForEntityDropdownIcon();
        Thread.sleep(5000);
        casePage.clickEntityDropdownIconJs();
        casePage.clickDeleteEntityButtonJs();
        casePage.waitConfirmDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntityJs();
        casePage.waitForDeleteText();
    }

    @Test(description = "Creating a new Case test", groups = {"Smoke", "CreatingNewCase"})
    public void createNewCaseTest() {

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
    public void positiveUpdateCaseTest() throws InterruptedException {

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
        Thread.sleep(5000);
        casePage.waitForPageLoaded();
        casePage.waitForCheckboxeLoaded();
        casePage.clickCheckboxIcon();
        casePage.clickUpdateCaseButtonJs();

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
        casePage.waitClickCase();
        casePage.clickCase();
        Assert.assertEquals(expectedUpdatingCase, casesDetailsPage.getCaseInfo());

    }


    @Test(description = "Checking the delete Case test", groups = {"Smoke"})
    public void deleteCaseTest() throws InterruptedException {

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
        Thread.sleep(5000);
        casePage.waitForEntityDropdownIcon();
        casePage.clickEntityDropdownIconJs();
        casePage.clickDeleteEntityButtonJs();
        casePage.waitConfirmDeleteEntityButton();
        casePage.clickToConfirmToDeleteEntityJs();
        casePage.waitForDeleteText();
        Assert.assertTrue(casePage.isPopupPresentDelete());
        Assert.assertTrue(casePage.isEmptyText());
    }


    @Test(description = "negative Update test", groups = {"Negative"})
    public void negativeUpdateCaseTest() {

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

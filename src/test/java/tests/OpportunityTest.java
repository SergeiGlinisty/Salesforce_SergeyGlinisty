package tests;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.Type;
import models.Account;
import models.Opportunity;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static constants.Constants.ACCOUNTNAME;
import static constants.Constants.DATA;
import static constants.Constants.NewLead.*;
import static enums.Stage.QUALIFICATION;


public class OpportunityTest extends BaseTest {

    @BeforeMethod(onlyForGroups = {"CreatingNewOpportunity"})
    public void createNewAccount() throws InterruptedException {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openAccountsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountModal.waitForPageLoaded();

        Faker faker = new Faker();

        Account testAccount = Account.builder().accountName(ACCOUNTNAME)
                .industry(Industry.EDUCATION)
                .phone(faker.phoneNumber().phoneNumber())
                .fax(faker.phoneNumber().phoneNumber())
                .website(WEB_SITE)
                .type(Type.ANALYST)
                .employees(faker.number().digit())
                .annualRevenue(ANNUAL_REVENUE)
                .description(DESCRIPTION)
                .build();

        newAccountModal.fillForm(testAccount);
        newAccountModal.clickSaveButton();
        Thread.sleep(5000);

    }


    @AfterMethod(onlyForGroups = {"CreatingNewOpportunity"})
    public void deleteOpportunity() throws InterruptedException {

        homePage.waitForOpportunityTab();
        homePage.openOpportunityTabJs();
        opportunitiesPage.waitForEntityDropdownIcon();
        Thread.sleep(5000);
        opportunitiesPage.clickEntityDropdownIconJs();
        opportunitiesPage.clickDeleteEntityButtonJs();
        opportunitiesPage.waitConfirmDeleteEntityButton();
        opportunitiesPage.clickToConfirmToDeleteEntityJs();
        opportunitiesPage.waitForDeleteText();
    }

    @Test(description = "Creating a new Opportunity test", groups = {"Smoke", "CreatingNewOpportunity"})
    public void createNewOpportunityTest() {

        homePage.waitForPageLoaded();
        homePage.openOpportunityTabJs();
        opportunitiesPage.waitForPageLoaded();
        opportunitiesPage.clickNewButtonOpportunity();
        newOpportunityModal.waitForPageLoaded();

        Faker faker = new Faker();

        Opportunity testOpportunity = Opportunity.builder()
                .opportunityName(faker.name().title())
                .accountName(ACCOUNTNAME)
                .closeData(DATA)
                .stage(QUALIFICATION)
                .build();

        newOpportunityModal.fillForm(testOpportunity);
        newOpportunityModal.clickSaveButton();
        opportunitiesPage.waitPopupPresent();
        Assert.assertTrue(opportunitiesPage.isPopupPresent());
        Assert.assertEquals(testOpportunity, opportunitiesDetailsPage.getOpportunityInfo());

    }


    @Test(description = "Deleting Opportunity test", groups = {"Smoke"})
    public void deleteOpportunityTest() throws InterruptedException {

        homePage.waitForPageLoaded();
        homePage.openOpportunityTabJs();
        opportunitiesPage.waitForPageLoaded();
        opportunitiesPage.clickNewButtonOpportunity();
        newOpportunityModal.waitForPageLoaded();

        Faker faker = new Faker();

        Opportunity testOpportunity = Opportunity.builder()
                .opportunityName(faker.name().title())
                .accountName(ACCOUNTNAME)
                .closeData(DATA)
                .stage(QUALIFICATION)
                .build();

        newOpportunityModal.fillForm(testOpportunity);
        newOpportunityModal.clickSaveButton();
        homePage.openOpportunityTabJs();
        homePage.openOpportunityTabJs();
        opportunitiesPage.waitForEntityDropdownIcon();
        opportunitiesPage.clickEntityDropdownIconJs();
        opportunitiesPage.clickDeleteEntityButtonJs();
        opportunitiesPage.clickToConfirmToDeleteEntityJs();
        opportunitiesPage.waitForDeleteText();
        Assert.assertTrue(opportunitiesPage.isPopupPresentDelete());
        Assert.assertTrue(opportunitiesPage.isEmptyText());

    }

}

package tests;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.Type;
import modals.NewAccountModal;
import modals.NewOpportunityModal;
import models.Account;
import models.Opportunity;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.accounts.AccountDetailsPage;
import pages.accounts.AccountsPage;
import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;

import static constants.Constants.ACCOUNTNAME;
import static constants.Constants.DATA;
import static constants.Constants.NewLead.*;
import static enums.Stage.QUALIFICATION;


public class OpportunityTest extends BaseTest {

    @BeforeMethod(onlyForGroups = {"CreatingNewOpportunity", "DeletingOpportunity"})
    public void createNewAccount() {
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
        homePage.logoutJs();

    }

    @AfterMethod(onlyForGroups = {"CreatingNewOpportunity"})
    public void delete() {

        homePage.openOpportunityTab();
        opportunitiesPage.waitForEntityDropdownIcon();
        opportunitiesPage.clickEntityDropdownIcon();
        opportunitiesPage.clickDeleteEntityButton();
        opportunitiesPage.waitConfirmDeleteEntityButton();
        opportunitiesPage.clickToConfirmToDeleteEntity();
        homePage.logout();
    }

    @Test(description = "Creating a new Opportunity test", groups = {"Smoke", "CreatingNewOpportunity"})
    public void createNewOpportunity() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openOpportunityTab();
        opportunitiesPage.waitForPageLoaded();
        opportunitiesPage.clickNewButton();
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
        Assert.assertTrue(opportunitiesPage.isPopupPresent());
        Assert.assertEquals(testOpportunity, opportunitiesDetailsPage.getOpportunityInfo());

    }


    @Test(description = "Deleting Opportunity test", groups = {"Smoke", "DeletingOpportunity"})
    public void deleteOpportunity() {

        loginPage.waitForPageLoaded();
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openOpportunityTab();
        opportunitiesPage.waitForPageLoaded();
        opportunitiesPage.clickNewButton();
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
        homePage.openOpportunityTab();
        homePage.openOpportunityTab();
        homePage.openOpportunityTabJs();
        opportunitiesPage.waitForEntityDropdownIcon();
        opportunitiesPage.clickEntityDropdownIcon();
        opportunitiesPage.clickDeleteEntityButton();
        opportunitiesPage.clickToConfirmToDeleteEntity();
        opportunitiesPage.waitForDeleteText();
        Assert.assertTrue(opportunitiesPage.isPopupPresentDelete());
        Assert.assertTrue(opportunitiesPage.isEmptyText());

    }

}

package tests;

import com.github.javafaker.Faker;

import modals.NewOpportunityModal;

import models.Opportunity;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.opportunities.OpportunitiesDetailsPage;
import pages.opportunities.OpportunitiesPage;

import static constants.Constants.*;

import static enums.Stage.QUALIFICATION;


public class OpportunityTest extends BaseTest{

    @BeforeClass
    public void initialise() {

        opportunitiesPage = new OpportunitiesPage(driver);
        opportunitiesDetailsPage = new OpportunitiesDetailsPage(driver);
        newOpportunityModal = new NewOpportunityModal(driver);


    }

    @Test
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

@Test
    public void deleteOpportunity(){

    loginPage.setUserName(USERNAME);
    loginPage.setPassword(PASSWORD);
    loginPage.clickLoginButton();
    homePage.waitForPageLoaded();
    homePage.openOpportunityTab();
    opportunitiesPage.waitForPageLoaded();
    opportunitiesPage.clickEntityDropdownIcon();
    opportunitiesPage.clickDeleteEntityButton();
    opportunitiesPage.clickToConfirmToDeleteEntity();
    opportunitiesPage.waitForDeleteText();
    Assert.assertTrue(opportunitiesPage.isPopupPresentDelete());

}


}

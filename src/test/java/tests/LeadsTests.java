package tests;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadDetailsPage;
import pages.LeadsPage;
import pages.modals.NewLeadModal;

import static constants.Constants.NewLead.*;
import static constants.Constants.PASSWORD;
import static constants.Constants.USERNAME;

@Log4j2
public class LeadsTests extends BaseTest {


    @BeforeClass
    public void initialise() {

        leadsPage = new LeadsPage(driver);
        leadDetailsPage = new LeadDetailsPage(driver);
        newLeadModal = new NewLeadModal(driver);
    }

    @Test
    public void createNewLeadTest() {
        log.info("Test started");
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        log.debug("Waited HomePage");
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        newLeadModal.waitForPageLoaded();
        log.debug("Moved to LeadDetailsPage");

        Faker faker = new Faker();

        Lead testLead = new Lead.LeadBuilder(faker.company().name(), LeadStatus.QUALIFIED)

                .lastName(faker.name().lastName())
                .title(TITLE)
                .phone(faker.phoneNumber().phoneNumber())
                .email(EMAIL)
                .rating(Rating.WARM)
                .annualRevenue(ANNUAL_REVENUE)
                .webSite(WEB_SITE)
                .numberOfEmployees(faker.number().digit())
                .leadSource(LeadSource.EMPLOYEE)
                .industry(Industry.EDUCATION)
                .description(DESCRIPTION)
                .build();
        log.info("Filling out the form");
        newLeadModal.fillForm(testLead);
        newLeadModal.clickSaveButton();
        Assert.assertTrue(leadsPage.isPopupPresent());
        log.debug("Created Lead");
        log.info("comparing objects");
        Assert.assertEquals(testLead, leadDetailsPage.getLeadInfo());
        log.info("Test finished");
    }

}

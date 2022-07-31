package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LeadsPage;
import pages.NewLeadPage;

import static constants.Constants.*;


public class LeadsTests extends BaseTest {


    @BeforeClass
    public void initialise() {

        leadsPage = new LeadsPage(driver);
        newLeadPage = new NewLeadPage(driver);
    }

    @Test
    public void createNewLeadTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openLeadsTab();
        leadsPage.waitForPageLoaded();
        leadsPage.clickNewButton();
        newLeadPage.waitForPageLoaded();
        newLeadPage.selectLeadStatus();
        newLeadPage.selectSalutation();
        newLeadPage.setFirstName(FIRSTNAME);
        newLeadPage.setLastName(LASTNAME);
        newLeadPage.setCompany(COMPANYNAME);
        newLeadPage.clicSaveButton();
        Assert.assertEquals(leadsPage.getLeadNameText(), LEAD, "Lead wasn't created!");

    }

}

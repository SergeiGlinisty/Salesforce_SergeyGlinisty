package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountsPage;
import pages.LeadsPage;
import pages.NewAccountPage;
import pages.NewLeadPage;

import static constants.Constants.*;

public class AccountsTest extends BaseTest {
    @BeforeClass
    public void initialise() {

        leadsPage = new LeadsPage(driver);
        newLeadPage = new NewLeadPage(driver);
        accountsPage = new AccountsPage(driver);
        newAccountPage = new NewAccountPage(driver);

    }

    @Test
    public void createNewAccount() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openAccountsTab();
        accountsPage.waitForPageLoaded();
        accountsPage.clickNewButton();
        newAccountPage.waitForPageLoaded();
        newAccountPage.setWebsite(WEBSITE);
        newAccountPage.setAccountName(ACCOUNTNAME);
        newAccountPage.setBillingStreet(BILLINGSTREET);
        newAccountPage.clicSaveAccountButton();
        Assert.assertEquals(accountsPage.getLAccountNameText(), ACCOUNT, "Account wasn't created!");

    }
}

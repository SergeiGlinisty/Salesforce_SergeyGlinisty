package tests;

import com.github.javafaker.Faker;
import enums.Industry;
import enums.Type;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AccountDetailsPage;
import pages.AccountsPage;
import pages.modals.NewAccountModal;

import static constants.Constants.*;
import static constants.Constants.NewLead.*;

public class AccountsTest extends BaseTest {
    @BeforeClass
    public void initialise() {

        accountsPage = new AccountsPage(driver);
        accountDetailsPage = new AccountDetailsPage(driver);
        newAccountModal = new NewAccountModal(driver);

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
        newAccountModal.waitForPageLoaded();

        Faker faker = new Faker();

        Account testAccount = new Account.AccountBuilder(ACCOUNTNAME)
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
        Assert.assertTrue(accountsPage.isPopupPresent());
        Assert.assertEquals(testAccount, accountDetailsPage.getLeadInfo());

    }
}
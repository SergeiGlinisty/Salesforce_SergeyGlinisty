package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.Constants.*;


public class LoginTest extends BaseTest {

    @Test(description = "Positive login test", groups = {"Smoke"})
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        Assert.assertTrue(homePage.isUserIconDisplayed());
    }

    @Test(description = "Negative login test", groups = {"Negative"}, dataProvider = "loginDataProvider")
    public void negativeLoginTest(String userName, String password, String expected) {
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMassageText(), expected);
    }
    @DataProvider(name = "loginDataProvider")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{

                {USERNAME, "", LOGIN_ERROR_TEXT_PASSWORD},
                {USERNAME, INCORRECT_PASSWORD, LOGIN_ERROR_TEXT},

        };
    }

    @Test(description = "Log out test", groups = {"Negative"})
    public void LogOut() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        Assert.assertTrue(homePage.isUserIconDisplayed());
        homePage.logout();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

}

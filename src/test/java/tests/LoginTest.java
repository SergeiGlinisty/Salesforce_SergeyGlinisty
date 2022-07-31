package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constants.PASSWORD;
import static constants.Constants.USERNAME;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        Assert.assertTrue(homePage.isUserIconDisplayed());
    }
}

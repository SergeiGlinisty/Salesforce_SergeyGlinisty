package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.Constants.*;
import static org.bouncycastle.cms.RecipientId.password;

@Log4j2
public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        log.info("Test Started");
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        log.info("Entered" + USERNAME + "and" + PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        Assert.assertTrue(homePage.isUserIconDisplayed());
    }

    @Test(description = "negative login test", groups = {"Regression", "Negative"}, dataProvider = "loginDataProvider")
    public void negativeLoginTest(String userName, String password, String expected) {
        log.info("Test Started");
        loginPage.setUserName(userName);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        log.info("Clicked Login button");
        Assert.assertEquals(loginPage.getErrorMassageText(), expected);
    }
    @DataProvider(name = "loginDataProvider")
    public Object[][] negativeLoginTestData() {
        return new Object[][]{

                {USERNAME, "", PASSWORD_NOT_ENTERED},

        };
    }

    @Test
    public void LogOut() {
        log.info("Test Started");
        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        log.info("Entered" + USERNAME + "and" + PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        Assert.assertTrue(homePage.isUserIconDisplayed());
        homePage.logout();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());
    }

}

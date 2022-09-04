package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.Constants.PASSWORD;
import static constants.Constants.USERNAME;

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
}

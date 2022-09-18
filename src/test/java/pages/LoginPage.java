package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PropertyReader;


@Log4j2
public class LoginPage extends BasePage {
    private final static By USERNAME_INPUT = By.xpath("//input[@id='username']");
    private final static By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    private final static By ERROR_MESSAGE = By.xpath("//div[@id='error']");
    private final static By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");
    protected static String WEBSITE = PropertyReader.getProperty("base_url");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting to display username field")
    public void waitForPageLoaded() {
        log.debug("Wait USERNAME_INPUT element");
        waitForElementDisplayed(USERNAME_INPUT);
    }

    @Step("Entering username")
    public void setUserName(String userName) {
        log.debug("Set USERNAME");
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
    }

    @Step("Entering password")
    public void setPassword(String password) {
        log.debug("Set PASSWORD");
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Clicking Login button")
    public void clickLoginButton() {
        log.debug("Click Login button");
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Opening website")
    public void open() {
        log.debug("Open website");
        driver.get(WEBSITE);
    }

    @Step("Getting error text")
    public String getErrorMassageText() {
        log.debug("Get error message text");
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Waiting to display Login button")
    public boolean isLoginButtonDisplayed() {
        log.debug("Wait to display Login button");
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

}

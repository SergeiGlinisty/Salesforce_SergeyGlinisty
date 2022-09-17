package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Constants.WEBSITE;

public class LoginPage extends BasePage {

    private final static By usernameInput = By.cssSelector("input#username");
    private final static By passwordInput = By.cssSelector("input#password");
    private final static By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");
    private final static By errorMessage = By.xpath("//div[@id='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(usernameInput);
    }

    public void setUserName(String userName) {
        driver.findElement(usernameInput).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void open() {
        driver.get(WEBSITE);
    }
    public String getErrorMassageText() {
        return driver.findElement(errorMessage).getText();
    }
    public boolean isLoginButtonDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

}

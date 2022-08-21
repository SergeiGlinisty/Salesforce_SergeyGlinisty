package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.Constants.WEBSITE;

public class LoginPage extends BasePage {

    private final static By usernameInput = By.cssSelector("input#username");
    private final static By passwordInput = By.cssSelector("input#password");
    private final static By loginButton = By.xpath("//input[@value='Log In']");

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
        driver.findElement(loginButton).click();
    }

    public void open() {
        driver.get(WEBSITE);
    }
}

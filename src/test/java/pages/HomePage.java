package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    public final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    public final static By ACCOUNTS_TAB_LOCATOR = By.xpath("//a[@title='Accounts']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public void waitForUserIconDisplayed() {
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    public boolean isUserIconDisplayed() {
        return driver.findElement(USER_ICON_LOCATOR).isDisplayed();
    }

    public void openLeadsTab() {
        jsClick(driver.findElement(LEADS_TAB_LOCATOR));
    }

    public void openAccountsTab() {
        jsClick(driver.findElement(ACCOUNTS_TAB_LOCATOR));
    }
}

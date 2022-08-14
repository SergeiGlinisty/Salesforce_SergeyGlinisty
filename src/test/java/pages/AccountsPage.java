package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends EntityBasePage {
    public final static By ACCOUNTS_PAGE_LOCATOR = By.xpath("//span[text()='Accounts']/parent::div");

    public final static By NEW_ACCOUNT = By.cssSelector("[data-refid=recordId]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ACCOUNTS_PAGE_LOCATOR);
    }

    public String getLAccountNameText() {
        return driver.findElement(NEW_ACCOUNT).getText();
    }


}

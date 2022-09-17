package pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

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


}

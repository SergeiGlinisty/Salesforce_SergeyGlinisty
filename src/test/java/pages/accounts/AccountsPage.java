package pages.accounts;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

@Log4j2
public class AccountsPage extends EntityBasePage {
    public final static By ACCOUNTS_PAGE_LOCATOR = By.xpath("//span[text()='Accounts']/parent::div");

    public final static By NEW_ACCOUNT = By.cssSelector("[data-refid=recordId]");

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting Accounts page icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting ACCOUNTS_PAGE_LOCATOR element");
        waitForElementDisplayed(ACCOUNTS_PAGE_LOCATOR);
    }


}

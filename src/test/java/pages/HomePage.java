package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class HomePage extends BasePage {
    public final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    public final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    public final static By ACCOUNTS_TAB_LOCATOR = By.xpath("//a[@title='Accounts']");

    public final static By CONTACTS_TAB_LOCATOR = By.xpath("//a[@title='Contacts']");
    public final static By OPPORTUNITY_TAB_LOCATOR = By.xpath("//*[text()='Opportunities']/parent::a");
    public final static By CASE_TAB_LOCATOR = By.xpath("//a[@title='Cases']");
    public final static By TASK_TAB_LOCATOR = By.xpath("//a[@title='Tasks']");
    public final static By REPORT_TAB_LOCATOR = By.xpath("//a[@title='Reports']");
    public final static By VIEW_PROFILE = By.xpath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action forceHeaderButton']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Waiting to appearance user Icon")
    public void waitForPageLoaded() {
        log.debug("Wait USER_ICON_LOCATOR element");
        waitForElementDisplayed(USER_ICON_LOCATOR);
    }

    @Step("Waiting to appearance user Icon")
    public boolean isUserIconDisplayed() {
        log.debug("Wait to display USER_ICON_LOCATOR element");
        return driver.findElement(USER_ICON_LOCATOR).isDisplayed();
    }

    @Step("Opening Leads tab")
    public void openLeadsTab() {
        log.debug("Open Leads Tab");
        jsClick(driver.findElement(LEADS_TAB_LOCATOR));
    }

    @Step("Opening Accounts tab")
    public void openAccountsTab() {
        log.debug("Open Accounts Tab");
        jsClick(driver.findElement(ACCOUNTS_TAB_LOCATOR));
    }

    @Step("Opening Contacts tab")
    public void openContactsTab() {
        log.debug("Open Contacts Tab");
        jsClick(driver.findElement(CONTACTS_TAB_LOCATOR));
    }

    @Step("Opening Opportunities tab")
    public void openOpportunityTab() {
        log.debug("Open Opportunity Tab");
        jsClick(driver.findElement(OPPORTUNITY_TAB_LOCATOR));
    }

    @Step("Opening Cases tab")
    public void openCaseTab() {
        log.debug("Open Cases Tab");
        jsClick(driver.findElement(CASE_TAB_LOCATOR));
    }

    @Step("Opening Tasks tab")
    public void openTaskTab() {
        log.debug("Open Tasks Tab");
        jsClick(driver.findElement(TASK_TAB_LOCATOR));
    }

    @Step("Opening Reports tab")
    public void openReportTab() {
        log.debug("Open Report Tab");
        jsClick(driver.findElement(REPORT_TAB_LOCATOR));
    }

    @Step("Log out")
    public void logout() {
        log.debug("Log out");
        jsClick(driver.findElement(VIEW_PROFILE));
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='profile-link-label logout uiOutputURL']")));
        element.click();

    }
}

package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

@Log4j2
public class HomePage extends BasePage {
    private final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    private final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    private final static By ACCOUNTS_TAB_LOCATOR = By.xpath("//a[@title='Accounts']");

    private final static By CONTACTS_TAB_LOCATOR = By.xpath("//a[@title='Contacts']");
    private final static By OPPORTUNITY_TAB_LOCATOR = By.xpath("//*[text()='Opportunities']/parent::a");
    private final static By CASE_TAB_LOCATOR = By.xpath("//a[@title='Cases']");
    private final static By TASK_TAB_LOCATOR = By.xpath("//a[@title='Tasks']");
    private final static By REPORT_TAB_LOCATOR = By.xpath("//a[@title='Reports']");
    private final static By VIEW_PROFILE = By.xpath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action forceHeaderButton']");

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
    public void openOpportunityTabJs() {
        log.debug("Open Opportunity Tab");
        jsClick(driver.findElement(OPPORTUNITY_TAB_LOCATOR));

    }


    @Step("Opening Opportunities tab")
    public void openOpportunityTab() {
        log.debug("Open Opportunity Tab");
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(OPPORTUNITY_TAB_LOCATOR);
        actions.moveToElement(elementLocator).doubleClick(elementLocator).build().perform();
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
        driver.findElement(VIEW_PROFILE).click();
        WebElement element = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")));
        element.click();

    }
    @Step("Log out")
    public void logoutJs() {
        log.debug("Log out");
        jsClick(driver.findElement(VIEW_PROFILE));
        jsClick(driver.findElement(By.xpath("//a[@class='profile-link-label logout uiOutputURL']")));


    }
}

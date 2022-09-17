package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public final static By USER_ICON_LOCATOR = By.cssSelector(".slds-avatar_profile-image-small");
    public final static By LEADS_TAB_LOCATOR = By.xpath("//*[@title='Leads']");
    public final static By ACCOUNTS_TAB_LOCATOR = By.xpath("//a[@title='Accounts']");

    public final static By CONTACTS_TAB_LOCATOR = By.xpath("//a[@title='Contacts']");
    public final static By OPPORTUNITY_TAB_LOCATOR = By.xpath("//a[@title='Opportunities']");
    public final static By CASE_TAB_LOCATOR = By.xpath("//a[@title='Cases']");
    public final static By TASK_TAB_LOCATOR = By.xpath("//a[@title='Tasks']");
    public final static By REPORT_TAB_LOCATOR = By.xpath("//a[@title='Reports']");


        public final static By VIEW_PROFILE = By.xpath("//button[@class='slds-button branding-userProfile-button slds-button slds-global-actions__avatar slds-global-actions__item-action forceHeaderButton']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
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

    public void openContactsTab() {
        jsClick(driver.findElement(CONTACTS_TAB_LOCATOR));
    }
    public void openOpportunityTab() {
        jsClick(driver.findElement(OPPORTUNITY_TAB_LOCATOR));
    }
    public void openCaseTab() {
        jsClick(driver.findElement(CASE_TAB_LOCATOR));
    }
    public void openTaskTab() {
        jsClick(driver.findElement(TASK_TAB_LOCATOR));
    }
    public void openReportTab() {
        jsClick(driver.findElement(REPORT_TAB_LOCATOR));
    }
    public void logout() {
        driver.findElement(VIEW_PROFILE).click();
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='profile-link-label logout uiOutputURL']")));
        element.click();

    }
}

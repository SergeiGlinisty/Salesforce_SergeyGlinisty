package pages.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

public class CasePage extends EntityBasePage {

    public final static By CASES_PAGE_LOCATOR = By.xpath("//span[text()='Cases']/parent::div");
    public final static By UPDATE_CASE_BUTTON = By.xpath("//div[@title='Update Case']/parent::a");
    public final static By CASE = By.xpath("//div/a[text()='New project']");
    public final static By SAVE_BUTTON = By.xpath("//*[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']");
    public CasePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(CASES_PAGE_LOCATOR);
    }

    public void clickUpdateCaseButton() {
        driver.findElement(UPDATE_CASE_BUTTON).click();
    }
    public void clickSaveButtonToUpdate() {
        driver.findElement(SAVE_BUTTON).click();
    }
       public void clickCase() {
        jsClick(driver.findElement(CASE));
    }

}

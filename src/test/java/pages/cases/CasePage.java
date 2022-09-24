package pages.cases;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

@Log4j2
public class CasePage extends EntityBasePage {

    private final static By CASES_PAGE_LOCATOR = By.xpath("//span[text()='Cases']/parent::div");
    private final static By UPDATE_CASE_BUTTON = By.xpath("//div[@title='Update Case']/parent::a");
    private final static By CASE = By.xpath("//div/a[text()='New project']");
    private final static By SAVE_BUTTON = By.xpath("//*[@class='slds-button slds-button_brand cuf-publisherShareButton undefined uiButton']");

    public CasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the case page icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting CASES_PAGE_LOCATOR element");
        waitForElementDisplayed(CASES_PAGE_LOCATOR);
    }

    @Step("Clicking the update case button")
    public void clickUpdateCaseButton() {
        log.debug("Clicking update button");
        driver.findElement(UPDATE_CASE_BUTTON).click();
    }

    @Step("Clicking the update case button")
    public void clickUpdateCaseButtonJs() {
        log.debug("Clicking update button");
        jsClick(driver.findElement(UPDATE_CASE_BUTTON));
    }

    @Step("Clicking the save case button")
    public void clickSaveButtonToUpdate() {
        log.debug("Clicking save button");
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Clicking the case tab")
    public void clickCase() {
        log.debug("Clicking Case tab");
        driver.findElement(CASE).click();
    }

    @Step("Waiting the case tab")
    public void waitClickCase() {
        log.debug("Waiting Case tab");
        waitForElementDisplayed(CASE);
        waitForElementClicable(CASE);
    }

}

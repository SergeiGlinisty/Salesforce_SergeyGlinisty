package pages.reports;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Log4j2
public class NewAccountReportPage extends BasePage {
    private final static By IFRAME = By.xpath("//iframe[@class='isEdit reportsReportBuilder']");
    private final static By IFRAME_VIEW = By.xpath("//iframe[@class='isView reportsReportBuilder']");

    private final static By ICON_LOCATOR_NEW_REPORT = By.xpath("//span[text()='Report']");
    private final static By SAVE_AND_RUN_BUTTON = By.xpath("//button[text()='Save & Run']");

    private final static By REPORT_NAME = By.xpath("//h1/span[@class='slds-page-header__title slds-truncate']");

    public NewAccountReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the new report icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting ICON_LOCATOR_NEW_REPORT element");
        waitForElementDisplayed(ICON_LOCATOR_NEW_REPORT);
    }

    @Step("Clicking the save and run button")
    public void clickSaveAndRunButton() {
        log.debug("Clicking SAVE_AND_RUN_BUTTON element");
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        driver.findElement(SAVE_AND_RUN_BUTTON).click();
        driver.switchTo().defaultContent();
    }

    @Step("Getting the report name info")
    public void getReportName() {
        log.debug("Getting REPORT_NAME info");
        WebElement iframe = driver.findElement(IFRAME_VIEW);
        driver.switchTo().frame(iframe);
        String actualReportName = driver.findElement(REPORT_NAME).getText();
        driver.switchTo().defaultContent();
    }
}

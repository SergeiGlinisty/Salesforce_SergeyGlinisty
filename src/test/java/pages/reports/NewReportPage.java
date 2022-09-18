package pages.reports;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Log4j2
public class NewReportPage extends BasePage {
    public final static By ALL_REPORT = By.xpath("//*[@class='report-type-section-list']//li/following-sibling::li/a[text()='All']");
    public final static By CREATE_REPORT_TITLE = By.xpath("//div/*[@class='slds-modal__header']");
    public final static By ACCOUNTS = By.xpath("//p[text()='Accounts']");
    public final static By START_REPORT_BUTTON = By.xpath("//button[text()='Start Report']");
    public final static By IFRAME = By.xpath("//iframe[@class='isEdit reportsReportBuilder']");

    public NewReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the create report title")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait CREATE_REPORT_TITLE element");
        waitForElementDisplayed(CREATE_REPORT_TITLE);
    }

    @Step("Selecting type report")
    public void selectTypeReport() {
        log.debug("Select report type");
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        driver.findElement(ALL_REPORT).click();
        driver.findElement(ACCOUNTS).click();
        driver.switchTo().defaultContent();
    }

    @Step("Clicking the start report button")
    public void clickStartReportButton() {
        log.debug("Click START_REPORT_BUTTON button");
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        driver.findElement(START_REPORT_BUTTON).click();
        driver.switchTo().defaultContent();
    }

}

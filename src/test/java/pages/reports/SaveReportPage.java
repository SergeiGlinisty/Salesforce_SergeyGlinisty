package pages.reports;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;

@Log4j2
public class SaveReportPage extends BasePage {
    private final static By IFRAME = By.xpath("//iframe[@class='isEdit reportsReportBuilder']");

    private final static By SAVE_REPORT_TITLE = By.xpath("//h2[text()='Save Report']");
    private final static By NEW_REPORT_NAME = By.cssSelector("input[id='reportName']");

    private final static By SAVE_REPORT_BUTTON = By.xpath("//*[@class='slds-button slds-button_brand report-save']");

    public SaveReportPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the save report title")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait SAVE_REPORT_TITLE element");
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        waitForElementDisplayed(SAVE_REPORT_TITLE);
        driver.switchTo().defaultContent();
    }

    @Step("Saving new report")
    public void saveNewReport() {
        log.debug("Save new report");
        Faker faker = new Faker();
        WebElement iframe = driver.findElement(IFRAME);
        driver.switchTo().frame(iframe);
        WebElement report = driver.findElement(NEW_REPORT_NAME);
        report.sendKeys(Keys.BACK_SPACE);
        report.sendKeys(faker.name().name());
        String expectedReportName = report.getText();
        driver.findElement(SAVE_REPORT_BUTTON).click();
        driver.switchTo().defaultContent();
    }

}

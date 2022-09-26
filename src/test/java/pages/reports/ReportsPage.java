package pages.reports;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

@Log4j2
public class ReportsPage extends EntityBasePage {
    private final static By REPORTS_PAGE_LOCATOR = By.xpath("//span[text()='Reports']/parent::li");
    private final static By NEW_REPORT_LOCATOR = By.xpath("//a[@title='New Report']");
    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting Reports page icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait REPORTS_PAGE_LOCATOR element");
        waitForElementDisplayed(REPORTS_PAGE_LOCATOR);
    }

    @Step("Clicking new report button ")
    public void clickNewReportButton() {
        log.debug("Click new report button");
        driver.findElement(NEW_REPORT_LOCATOR).click();
    }
}

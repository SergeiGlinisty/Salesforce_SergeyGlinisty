package pages.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

public class ReportsPage extends EntityBasePage {
    public final static By REPORTS_PAGE_LOCATOR = By.xpath("//span[text()='Reports']/parent::li");
    public final static By NEW_REPORT_LOCATOR = By.xpath("//a[@title='New Report']");
    public ReportsPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(REPORTS_PAGE_LOCATOR);
    }

    public void clickNewReportButton() {
        driver.findElement(NEW_REPORT_LOCATOR ).click();
    }
}

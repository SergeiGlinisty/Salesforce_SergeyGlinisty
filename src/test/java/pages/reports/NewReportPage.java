package pages.reports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NewReportPage extends BasePage {
    public final static By ICON_LOCATOR_ALL_REPORT= By.xpath("//*[@class='report-type-section-list']//li/following-sibling::li/a[text()='All']");
    public final static By CREATE_REPORT_TITLE= By.xpath("//div/*[@class='slds-modal__header']");

    public NewReportPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(CREATE_REPORT_TITLE);
    }

    public void clickAllReports() {
        jsClick(driver.findElement(ICON_LOCATOR_ALL_REPORT));
    }

    public void clickAll() {
        driver.findElement(ICON_LOCATOR_ALL_REPORT).click();

    }

}

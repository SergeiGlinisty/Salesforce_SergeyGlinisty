package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadsPage extends BasePage {
    public final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    public final static By ICON_LOCATOR = By.xpath("//span[text()='Leads']/parent::div");
    public final static By NEW_LEAD = By.xpath("//a[@target='_blank']");


    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }

    public String getLeadNameText() {
        return driver.findElement(NEW_LEAD).getText();
    }
}

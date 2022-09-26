package pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

public class LeadsPage extends EntityBasePage {
    private final static By ICON_LOCATOR = By.xpath("//span[text()='Leads']/parent::div");
    private final static By NEW_LEAD = By.xpath("//a[@target='_blank']");


    public LeadsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR);
    }

    public String getLeadNameText() {
        return driver.findElement(NEW_LEAD).getText();
    }
}

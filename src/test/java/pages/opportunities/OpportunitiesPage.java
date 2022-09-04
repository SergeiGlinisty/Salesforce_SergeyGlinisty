package pages.opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.EntityBasePage;

public class OpportunitiesPage extends EntityBasePage {

    public final static By OPPORTUNITIES_PAGE_LOCATOR = By.xpath("//span[text()='Opportunities']/parent::div");

    public OpportunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(OPPORTUNITIES_PAGE_LOCATOR);
    }

}

package pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;


public class NewLeadPage extends BasePage {

    public final static By ICON_LOCATOR_NEW_LEAD = By.xpath("//h2[text()='New Lead']");


    public NewLeadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR_NEW_LEAD);
    }

}

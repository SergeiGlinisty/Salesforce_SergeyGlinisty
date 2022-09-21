package pages.opportunities;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

@Log4j2
public class OpportunitiesPage extends EntityBasePage {

    private final static By OPPORTUNITIES_PAGE_LOCATOR = By.xpath("//span[text()='Opportunities' and @class='slds-var-p-right_x-small']");

    public OpportunitiesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the Opportunities page icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting OPPORTUNITIES_PAGE_LOCATOR element");
        waitForElementDisplayed(OPPORTUNITIES_PAGE_LOCATOR);
    }

}

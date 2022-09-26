package pages.opportunities;

import enums.Stage;
import enums.elements.LightningFormatedElement;
import enums.elements.OpportunityFormatedElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class OpportunitiesDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public OpportunitiesDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting the details button")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting DETAILS_BUTTON element");
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    @Step("Getting theOpportunity info")
    public Opportunity getOpportunityInfo() {
        log.debug("Getting Opportunity info");
        String opportunityName = new LightningFormatedElement(driver, "Opportunity Name").getText();
        String accountName = new OpportunityFormatedElement(driver, "Account Name").getText();
        String closeData = new LightningFormatedElement(driver, "Close Date").getText();
        String stage = new LightningFormatedElement(driver, "Stage").getText();
        Opportunity.OpportunityBuilder opportunityBuilder = Opportunity.builder()
                .opportunityName(opportunityName)
                .accountName(accountName)
                .closeData(closeData)
                .stage(Stage.fromString(stage));


        return opportunityBuilder.build();

    }



}

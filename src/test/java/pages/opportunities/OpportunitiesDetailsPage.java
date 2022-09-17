package pages.opportunities;

import elements.LightningFormatedElement;
import enums.LeadStatus;
import enums.Stage;
import models.Contact;
import models.Opportunity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class OpportunitiesDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public OpportunitiesDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Opportunity getOpportunityInfo() {
        String opportunityName = new LightningFormatedElement(driver, "Opportunity Name").getText();
        String accountName = new LightningFormatedElement(driver, "Account Name").getText();
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

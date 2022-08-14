package pages;

import elements.LightningFormatedElement;
import enums.Industry;
import enums.LeadSource;
import enums.LeadStatus;
import enums.Rating;
import models.Lead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeadDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public LeadDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Lead getLeadInfo() {

        String leadStatus = new LightningFormatedElement(driver, "Lead Status").getText();
        String company = new LightningFormatedElement(driver, "Company").getText();
        String lastName = new LightningFormatedElement(driver, "Name").getText();

        Lead.LeadBuilder leadBuilder = new Lead.LeadBuilder(company, LeadStatus.fromString(leadStatus));


        String description = new LightningFormatedElement(driver, "Description").getText();
        if (description != "") {
            leadBuilder.description(description);
        }

        String title = new LightningFormatedElement(driver, "Title").getText();
        if (title != "") {
            leadBuilder.title(title);
        }
        String email = new LightningFormatedElement(driver, "Email").getText();
        if (email != "") {
            leadBuilder.email(email);
        }
        String webSite = new LightningFormatedElement(driver, "Website").getText();
        if (webSite != "") {
            leadBuilder.webSite(webSite);
        }
        String phone = new LightningFormatedElement(driver, "Phone").getText();
        if (phone != "") {
            leadBuilder.phone(phone);
        }

        String rating = new LightningFormatedElement(driver, "Rating").getText();
        if (rating != "") {
            leadBuilder.rating(Rating.fromString(rating));
        }
        String industry = new LightningFormatedElement(driver, "Industry").getText();
        if (industry != "") {
            leadBuilder.industry(Industry.fromString(industry));
        }
        String numberOfEmployees = new LightningFormatedElement(driver, "No. of Employees").getText();
        if (numberOfEmployees != "") {
            leadBuilder.numberOfEmployees(numberOfEmployees);
        }
        String leadSource = new LightningFormatedElement(driver, "Lead Source").getText();
        if (leadSource != "") {
            leadBuilder.leadSource(LeadSource.fromString(leadSource));
        }
        String annualRevenue = new LightningFormatedElement(driver, "Annual Revenue").getText();
        if (annualRevenue != "") {
            leadBuilder.annualRevenue(annualRevenue);
        }


        return leadBuilder.build();

    }

}

package pages.accounts;

import elements.LightningFormatedElement;
import models.Account;
import enums.Industry;
import enums.Type;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class AccountDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public AccountDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Account getLeadInfo() {

        String accountName = new LightningFormatedElement(driver, "Account Name").getText();
        Account.AccountBuilder accountBuilder = Account.builder().accountName(accountName);
        String fax = new LightningFormatedElement(driver, "Fax").getText();
        if (fax != "") {
            accountBuilder.fax(fax);
        }
        String webSite = new LightningFormatedElement(driver, "Website").getText();
        if (webSite != "") {
            accountBuilder.website(webSite);
        }
        String phone = new LightningFormatedElement(driver, "Phone").getText();
        if (phone != "") {
            accountBuilder.phone(phone);
        }

        String description = new LightningFormatedElement(driver, "Description").getText();
        if (description != "") {
            accountBuilder.description(description);
        }
        String type = new LightningFormatedElement(driver, "Type").getText();
        if (type != "") {
            accountBuilder.type(Type.fromString(type));
        }

        String industry = new LightningFormatedElement(driver, "Industry").getText();
        if (industry != "") {
            accountBuilder.industry(Industry.fromString(industry));
        }
        String employees = new LightningFormatedElement(driver, "Employees").getText();
        if (employees != "") {
            accountBuilder.employees(employees);
        }

        String annualRevenue = new LightningFormatedElement(driver, "Annual Revenue").getText();
        if (annualRevenue != "") {
            accountBuilder.annualRevenue(annualRevenue);
        }


        return accountBuilder.build();

    }


}

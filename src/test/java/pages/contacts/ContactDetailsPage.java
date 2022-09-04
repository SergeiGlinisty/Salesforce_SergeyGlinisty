package pages.contacts;

import elements.LightningFormatedElement;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class ContactDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Contact getLeadInfo() {
        String lastName = new LightningFormatedElement(driver, "Name").getText();
        String accountName = new LightningFormatedElement(driver, "Account Name").getText();
        Contact.ContactBuilder contactBuilder = Contact.builder().lastName(lastName).accountName(accountName);

        String title = new LightningFormatedElement(driver, "Title").getText();
        if (title != "") {
            contactBuilder.title(title);
        }
        String phone = new LightningFormatedElement(driver, "Phone").getText();
        if (phone != "") {
            contactBuilder.phone(phone);
        }
        String email = new LightningFormatedElement(driver, "Email").getText();
        if (email != "") {
            contactBuilder.email(email);
        }
        String mobile = new LightningFormatedElement(driver, "Mobile").getText();
        if (mobile != "") {
            contactBuilder.mobile(mobile);
        }

        return contactBuilder.build();

    }
}

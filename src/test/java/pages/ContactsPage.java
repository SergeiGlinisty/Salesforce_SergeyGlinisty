package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends EntityBasePage {
    public final static By CONTACTS_PAGE_LOCATOR = By.xpath("//span[text()='Contacts']/parent::div");


    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(CONTACTS_PAGE_LOCATOR);
    }

}

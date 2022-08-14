package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class NewLeadPage extends BasePage {

    public final static By ICON_LOCATOR_NEW_LEAD = By.xpath("//h2[text()='New Lead']");
    public final static By SALUTATION_BUTTON = By.xpath("//lightning-combobox[@class='slds-form-element']");
    public final static By SALUTATION = By.xpath("//lightning-base-combobox-item[@data-value='Mr.']");

    public final static By FIRST_NAME = By.xpath("//input[@name='firstName']");
    public final static By LAST_NAME = By.xpath("//input[@name='lastName']");
    public final static By COMPANY = By.xpath("//input[@name='Company']");
    public final static By LEAD_STATUS_BUTTON = By.xpath("//button[@aria-label='Lead Status, New']");

    public final static By STATUS_BUTTON = By.xpath("//lightning-base-combobox-item[@data-value='Contacted']");
    public final static By SaveButton = By.xpath("//button[@name='SaveEdit']");

    public NewLeadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR_NEW_LEAD);
    }

    public void selectSalutation() {

        wait.until(ExpectedConditions
                        .elementToBeClickable(SALUTATION_BUTTON))
                .click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(SALUTATION))
                .click();

    }

    public void setFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void setCompany(String company) {
        driver.findElement(COMPANY).sendKeys(company);
    }

    public void selectLeadStatus() {

        wait.until(ExpectedConditions
                        .elementToBeClickable(LEAD_STATUS_BUTTON))
                .click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(STATUS_BUTTON))
                .click();

    }

    public void clicSaveButton() {
        driver.findElement(SaveButton).click();
    }
}

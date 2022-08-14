package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewAccountPage extends BasePage {


    public final static By ICON_LOCATOR_NEW_ACCOUNT = By.xpath("//h2[text()='New Account']");
    public final static By WEBSITE = By.xpath("//input[@type='url']");
    public final static By ACCOUNT_NAME = By.xpath("//input[@class='default input uiInput uiInputTextForAutocomplete uiInput--default uiInput--input uiInput uiAutocomplete uiInput--default uiInput--lookup']");
    public final static By TYPE_BUTTON = By.xpath("//a[@class='select']");
    public final static By TYPE = By.xpath("//a[@title='Customer']");
    public final static By BILLING_STREET = By.xpath("//textarea[@placeholder='Billing Street']");

    public final static By SAVE_ACCOUNT_BUTTON = By.xpath("//button[@title='Save']");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR_NEW_ACCOUNT);
    }

    public void setWebsite(String website) {
        driver.findElement(WEBSITE).sendKeys(website);
    }

    public void setAccountName(String accountName) {
        driver.findElement(ACCOUNT_NAME).sendKeys(accountName);
    }

    public void setBillingStreet(String billingStreet) {
        driver.findElement(BILLING_STREET).sendKeys(billingStreet);
    }

    public void clicSaveAccountButton() {
        driver.findElement(SAVE_ACCOUNT_BUTTON).click();
    }

    public void selectType() {

        wait.until(ExpectedConditions
                        .elementToBeClickable(TYPE_BUTTON))
                .click();
        wait.until(ExpectedConditions
                        .elementToBeClickable(TYPE))
                .click();

    }


}

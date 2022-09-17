package pages.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NewAccountPage extends BasePage {


    public final static By ICON_LOCATOR_NEW_ACCOUNT = By.xpath("//h2[text()='New Account']");


    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(ICON_LOCATOR_NEW_ACCOUNT);
    }


}

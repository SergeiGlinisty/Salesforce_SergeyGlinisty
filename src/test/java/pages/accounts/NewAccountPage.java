package pages.accounts;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class NewAccountPage extends BasePage {


    private final static By ICON_LOCATOR_NEW_ACCOUNT = By.xpath("//h2[text()='New Account']");


    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting new Account icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Waiting ICON_LOCATOR_NEW_ACCOUNT element");
        waitForElementDisplayed(ICON_LOCATOR_NEW_ACCOUNT);
    }


}

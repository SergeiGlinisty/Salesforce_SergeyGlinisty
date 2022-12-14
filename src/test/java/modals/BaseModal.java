package modals;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public abstract class BaseModal extends BasePage {

    private final static By SAVE_BUTTON = By.xpath("//*[@title='Save']");

    public BaseModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(SAVE_BUTTON);
        waitForElementClicable(SAVE_BUTTON);

    }

    public void clickSaveButton() {
        log.info("Clicking save button");
        driver.findElement(SAVE_BUTTON).click();
    }
}

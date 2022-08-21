package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public abstract class EntityBasePage extends BasePage {
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By ENTITIES_LINKS_LOCATOR = By.cssSelector("a[data-refid=recordId]");
    private final static By POPUP_LOCATOR = By.xpath("//*[text()=' was created.']");

    public EntityBasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(NEW_BUTTON);
        waitForElementClicable(NEW_BUTTON);
    }

    public void clickNewButton() {
        driver.findElement(NEW_BUTTON).click();
    }

    public boolean isPopupPresent() {
        return driver.findElement(POPUP_LOCATOR).isDisplayed();
    }

}

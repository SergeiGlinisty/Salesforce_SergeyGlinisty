package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public abstract class EntityBasePage extends BasePage {
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By TABLE_LOCATOR = By.cssSelector("table[role=grid]");
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

    private List<WebElement> getAllEntitiesLinks() {      //найти лист элементов таблицы
        return driver.findElements(ENTITIES_LINKS_LOCATOR);
    }

    public void openEntityByName(String entityName) {
        List<WebElement> allLinks = getAllEntitiesLinks();
        allLinks.stream().filter(webElement -> webElement.getText().equals(entityName)).findFirst().get().click();
    }

    public void openFirstEntityFromTable() {
        List<WebElement> allLinks = getAllEntitiesLinks();
        allLinks.get(0).click();
    }

    public boolean isPopupPresent() {
        return driver.findElement(POPUP_LOCATOR).isDisplayed();
    }

}

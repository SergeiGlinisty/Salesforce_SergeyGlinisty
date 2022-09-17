package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public abstract class EntityBasePage extends BasePage {
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By ENTITIES_LINKS_LOCATOR = By.cssSelector("a[data-refid=recordId]");
    private final static By POPUP_LOCATOR = By.xpath("//*[text()=' was created.']");
    public final static By ENTITY_DROPDOWN_ICON = By.xpath("//*[@class='forceVirtualActionMarker forceVirtualAction']");
    public final static By DELETE_BUTTON = By.xpath("//li/*[@title='Delete']");
    public final static By CONFIRM_DELETE_BUTTON = By.xpath("//button[@title='Delete']");
    public final static By CHECKBOX = By.xpath("//div[@class='slds-cell-fixed slds-align_absolute-center slds-th__action']/span");
    public final static By POPUP_LOCATOR_NEGATIVE_UPDATE = By.xpath("//div/span[text()='Select at least one record.']");
    private final static By POPUP_LOCATOR_DELETE = By.xpath("//div/span[@class='toastMessage slds-text-heading--small forceActionsText']");
    private final static By POPUP_LOCATOR_POSITIVE_UPDATE = By.xpath("//div/span[@class='toastMessage slds-text-heading--small forceActionsText']");

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
    public boolean isPopupPresentDelete() {
        return driver.findElement(POPUP_LOCATOR_DELETE).isDisplayed();
    }
    public boolean isPopupPresentNegativeUpdate() {
        return driver.findElement(POPUP_LOCATOR_NEGATIVE_UPDATE).isDisplayed();
    }
    public boolean isPopupPresentPositiveUpdate() {
        return driver.findElement(POPUP_LOCATOR_POSITIVE_UPDATE).isDisplayed();
    }

    public void clickEntityDropdownIcon() {
        driver.findElement(ENTITY_DROPDOWN_ICON).click();
    }
    public void clickDeleteEntityButton() {
        driver.findElement(DELETE_BUTTON).click();
    }
    public void clickCheckboxIcon() {
        driver.findElement(CHECKBOX).click();
    }
    public void clickToConfirmToDeleteEntity() {
        driver.findElement(CONFIRM_DELETE_BUTTON).click();
    }
    public void waitForDeleteText() {
        waitForElementDisplayed(POPUP_LOCATOR_DELETE);
    }



}

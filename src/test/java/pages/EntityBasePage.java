package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public abstract class EntityBasePage extends BasePage {
    private final static By NEW_BUTTON = By.cssSelector("div.active a[title=New]");
    private final static By ENTITIES_LINKS_LOCATOR = By.cssSelector("a[data-refid=recordId]");
    private final static By POPUP_LOCATOR_SAVE = By.xpath("//div/span[contains(text(),' was saved')]");
    private final static By ENTITY_DROPDOWN_ICON = By.xpath("//*[@class='forceVirtualActionMarker forceVirtualAction']/a");
    private final static By DELETE_BUTTON = By.xpath("//li/*[@title='Delete']");
    private final static By CONFIRM_DELETE_BUTTON = By.xpath("//*[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton']");
    private final static By CHECKBOX = By.xpath("//div[@class='slds-cell-fixed slds-align_absolute-center slds-th__action']/span");
    private final static By POPUP_LOCATOR_NEGATIVE_UPDATE = By.xpath("//div/span[text()='Select at least one record.']");
    private final static By POPUP_LOCATOR_CREATE = By.xpath("//*[text()=' was created.']");
    private final static By POPUP_LOCATOR = By.xpath("//div/span[@class='toastMessage slds-text-heading--small forceActionsText']");
    private final static By POPUP_LOCATOR_DELETE = By.xpath("//*[contains(text(),'was deleted.')]");
    private final static By EMPTY_PAGE_TEXT = By.xpath("//div[@class='emptyContent slds-is-absolute']//p//span[text()='Try switching list views.']");

    public EntityBasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting New button")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait NEW_BUTTON element");
        waitForElementDisplayed(NEW_BUTTON);
        waitForElementClicable(NEW_BUTTON);
    }

    @Step("Clicking New button")
    public void clickNewButton() {
        log.debug("Click NEW_BUTTON");
        driver.findElement(NEW_BUTTON).click();
    }

    @Step("Checking display the create popup icon")
    public boolean isPopupPresent() {
        log.debug("Wait to display POPUP_LOCATOR_CREATE");
        return driver.findElement(POPUP_LOCATOR_CREATE).isDisplayed();
    }

    @Step("Checking to display the delete popup icon")
    public boolean isPopupPresentDelete() {
        log.debug("Wait to display POPUP_LOCATOR");
        return driver.findElement(POPUP_LOCATOR).isDisplayed();
    }

    @Step("Checking to display the save popup icon")
    public boolean isPopupPresentSaved() {
        log.debug("Wait to display POPUP_LOCATOR_SAVE");
        return driver.findElement(POPUP_LOCATOR_SAVE).isDisplayed();
    }

    @Step("Checking to display popup text ")
    public boolean isPopupPresentNegativeUpdate() {
        log.debug("Wait to display POPUP_LOCATOR_NEGATIVE_UPDATE");
        return driver.findElement(POPUP_LOCATOR_NEGATIVE_UPDATE).isDisplayed();
    }

    @Step("Checking to display popup text ")
    public boolean isPopupPresentPositiveUpdate() {
        log.debug("Wait to display POPUP_LOCATOR");
        return driver.findElement(POPUP_LOCATOR).isDisplayed();
    }

    @Step("Waiting to display empty page text ")
    public boolean isEmptyText() {
        log.debug("Wait to display empty page text ");
        return driver.findElement(EMPTY_PAGE_TEXT).isDisplayed();
    }

    @Step("Clicking entity dropdown icon ")
    public void clickEntityDropdownIcon() {
        log.debug("Click entity dropdown Icon");
        driver.findElement(ENTITY_DROPDOWN_ICON).click();
    }
    @Step("Clicking entity dropdown icon ")
    public void clickEntityDropdownIconJs() {
        log.debug("Click entity dropdown Icon");
        jsClick(driver.findElement(ENTITY_DROPDOWN_ICON));
    }

    @Step("Clicking the delete entity button ")
    public void clickDeleteEntityButton() {
        log.debug("Click to delete entity button");
        driver.findElement(DELETE_BUTTON).click();
    }

    @Step("Clicking checkbox icon ")
    public void clickCheckboxIcon() {
        log.debug("Click Checkbox Icon");
        driver.findElement(CHECKBOX).click();
    }

    @Step("Clicking the confirm deleting entity ")
    public void clickToConfirmToDeleteEntity() {
        log.debug("Click to confirm deleting Entity");
        driver.findElement(CONFIRM_DELETE_BUTTON).click();

    }
    @Step("Waiting the confirm deleting entity button ")
    public void waitConfirmDeleteEntityButton() {
        log.debug("Waiting the confirm deleting entity button");
        waitForElementDisplayed(CONFIRM_DELETE_BUTTON);
        waitForElementClicable(CONFIRM_DELETE_BUTTON);
    }



    @Step("Clicking entity dropdown icon ")
    public void waitForDeleteText() {
        log.debug("Wait POPUP_LOCATOR element");
        waitForElementDisplayed(POPUP_LOCATOR);
        waitForElementClicable(POPUP_LOCATOR);
    }

    @Step("Waiting to load checkbox")
    public void waitForCheckboxeLoaded() {
        log.debug("Wait to load checkbox");
        waitForElementDisplayed(CHECKBOX);
        waitForElementClicable(CHECKBOX);
    }
    @Step("Waiting entity dropdown icon")
    public void waitForEntityDropdownIcon() {
        log.debug("Waiting ENTITY_DROPDOWN_ICON element");
        waitForElementDisplayed(ENTITY_DROPDOWN_ICON);
        waitForElementClicable(ENTITY_DROPDOWN_ICON);
    }

}

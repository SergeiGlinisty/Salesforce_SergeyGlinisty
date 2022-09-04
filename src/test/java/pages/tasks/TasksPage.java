package pages.tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

public class TasksPage extends EntityBasePage {

    public final static By TASKS_PAGE_LOCATOR = By.xpath("//div[text()='Task']");
    public final static By NEW_TASK_LOCATOR = By.xpath("//*[@title='New Task']/parent::li");
    public final static By TASKS_DROPDOWN_ICON = By.xpath("//a[@title='Show one more action' and @class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']");
    public TasksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(TASKS_PAGE_LOCATOR);
    }
    public void clickTaskDropdownIcon() {
        driver.findElement(TASKS_DROPDOWN_ICON).click();
    }
    public void clickNewTaskButton() {
        driver.findElement(NEW_TASK_LOCATOR ).click();
    }
}

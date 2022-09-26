package pages.tasks;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EntityBasePage;

@Log4j2
public class TasksPage extends EntityBasePage {

    private final static By TASKS_PAGE_LOCATOR = By.xpath("//div[text()='Task']");
    private final static By NEW_TASK_LOCATOR = By.xpath("//*[@title='New Task']/parent::li");
    private final static By TASKS_DROPDOWN_ICON = By.xpath("//span[text()='Show more actions' ]/ancestor::a");
    public TasksPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting Task page icon")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait TASKS_PAGE_LOCATOR element");
        waitForElementDisplayed(TASKS_PAGE_LOCATOR);
    }

    @Step("Clicking Task dropdown icon")
    public void clickTaskDropdownIcon() {
        log.debug("Click Task dropdown Icon");
        driver.findElement(TASKS_DROPDOWN_ICON).click();
    }

    @Step("Clicking new Task button")
    public void clickNewTaskButton() {
        log.debug("Click new Task button");
        driver.findElement(NEW_TASK_LOCATOR).click();
    }
}

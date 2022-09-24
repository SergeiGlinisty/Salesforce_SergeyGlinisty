package pages.tasks;

import enums.PriorityTask;
import enums.StatusTask;
import enums.elements.TaskFormatedElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Log4j2
public class TasksDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");
    public TasksDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Waiting to display Task details button")
    @Override
    public void waitForPageLoaded() {
        log.debug("Wait DETAILS_BUTTON element");
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    @Step("Getting Task info")
    public Task getTaskInfo() {
        log.debug("Get Task info");
        String statusTask = new TaskFormatedElement(driver, "Status").getText();
        String priorityTask = new TaskFormatedElement(driver, "Priority").getText();
       Task.TaskBuilder taskBuilder = Task.builder()
                .statusTask(StatusTask.fromString(statusTask))
                .priorityTask(PriorityTask.fromString(priorityTask));
        String subject = new TaskFormatedElement(driver, "Subject").getText();
        if (subject != "") {
            taskBuilder.subject(subject);
        }
        String comments = new TaskFormatedElement(driver, "Comments").getText();
        if (comments != "") {
            taskBuilder.comments(comments);
        }


        return taskBuilder.build();

    }


}

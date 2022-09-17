package pages.tasks;

import elements.TaskFormatedElement;
import enums.PriorityTask;
import enums.StatusTask;
import models.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TasksDetailsPage extends BasePage {

    private final static By DETAILS_BUTTON = By.xpath("//*[@class='slds-tabs_default__link' and @data-label='Details']");
    public TasksDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitForPageLoaded() {
        waitForElementDisplayed(DETAILS_BUTTON);
    }

    public Task getTaskInfo() {
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

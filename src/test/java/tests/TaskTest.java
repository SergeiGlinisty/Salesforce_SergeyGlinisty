package tests;

import com.github.javafaker.Faker;
import models.Task;
import org.testng.Assert;
import org.testng.annotations.Test;

import static enums.PriorityTask.NORMAL;
import static enums.StatusTask.COMPLETED;

public class TaskTest  extends BaseTest{

    @Test(description = "Create a new Task test", groups = {"Smoke"})
    public void createNewTask() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openTaskTab();
        tasksPage.waitForPageLoaded();
        tasksPage.clickTaskDropdownIcon();
        tasksPage.clickNewTaskButton();
        newTaskModal.waitForPageLoaded();

        Faker faker = new Faker();
        Task testTask = Task.builder()
                .subject(faker.name().title())
                .comments(faker.name().title())
                .statusTask(COMPLETED)
                .priorityTask(NORMAL)
                .build();

        newTaskModal.fillForm(testTask);
        newTaskModal.clickSaveButton();
        Assert.assertTrue(tasksPage.isPopupPresent());
        Assert.assertEquals(testTask, tasksDetailsPage.getTaskInfo());


    }
}

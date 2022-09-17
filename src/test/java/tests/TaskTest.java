package tests;

import com.github.javafaker.Faker;
import modals.NewCaseModal;
import modals.NewTaskModal;
import models.Case;
import models.Task;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.cases.CasePage;
import pages.cases.CasesDetailsPage;
import pages.tasks.TasksDetailsPage;
import pages.tasks.TasksPage;

import static constants.Constants.PASSWORD;
import static constants.Constants.USERNAME;
import static enums.CaseOrigin.TWITTER;
import static enums.PriorityTask.NORMAL;
import static enums.Status.OPEN;
import static enums.StatusTask.COMPLETED;

public class TaskTest  extends BaseTest{

    @BeforeClass
    public void initialise() {

        tasksPage = new TasksPage(driver);
        tasksDetailsPage = new TasksDetailsPage(driver);
        newTaskModal = new NewTaskModal(driver);


    }

    @Test
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

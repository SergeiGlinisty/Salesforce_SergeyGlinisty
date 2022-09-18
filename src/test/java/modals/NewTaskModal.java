package modals;

import elements.CaseDropdown;
import elements.TaskSearchInput;
import elements.TaskTextarea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Task;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewTaskModal extends BaseModal{
    public NewTaskModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Task form")
    public void fillForm(Task inputTask) {
        log.debug("Filling new Task form");
        new TaskSearchInput(driver, "Subject").setValue(inputTask.getSubject());
        new TaskTextarea(driver, "Comments").setValue(inputTask.getComments());
        new CaseDropdown(driver, "Status").selectByVisibleText(inputTask.getStatusTask().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputTask.getPriorityTask().name);

    }

}

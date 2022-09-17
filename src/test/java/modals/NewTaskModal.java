package modals;

import elements.CaseDropdown;
import elements.LightningInput;
import elements.TaskSearchInput;
import elements.TaskTextarea;
import models.Case;
import models.Task;
import org.openqa.selenium.WebDriver;

public class NewTaskModal extends BaseModal{
    public NewTaskModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Task inputTask) {
        new TaskSearchInput(driver, "Subject").setValue(inputTask.getSubject());
        new TaskTextarea(driver, "Comments").setValue(inputTask.getComments());
        new CaseDropdown(driver, "Status").selectByVisibleText(inputTask.getStatusTask().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputTask.getPriorityTask().name);

    }

}

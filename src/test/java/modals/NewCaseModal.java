package modals;

import elements.*;
import models.Case;
import models.Opportunity;
import org.openqa.selenium.WebDriver;

public class NewCaseModal extends BaseModal{


    public NewCaseModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Case inputCase) {

        new CaseDropdown(driver, "Status").selectByVisibleText(inputCase.getStatus().name);
        new CaseDropdown(driver, "Case Origin").selectByVisibleText(inputCase.getCaseOrigin().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputCase.getPriority().name);
        new AccountTextarea(driver, "Description").setValue(inputCase.getDescription());
        new AccountInput(driver, "Subject").setValue(inputCase.getSubject());

    }
    public void fillFormUpdate(Case inputCase) {

        new CaseDropdown(driver, "Status").selectByVisibleText(inputCase.getStatus().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputCase.getPriority().name);

    }
}

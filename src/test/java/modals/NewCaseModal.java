package modals;

import enums.elements.AccountInput;
import enums.elements.AccountTextarea;
import enums.elements.CaseDropdown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewCaseModal extends BaseModal{


    public NewCaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Case form")
    public void fillForm(Case inputCase) {
        log.debug("Filling new Account form");
        new CaseDropdown(driver, "Status").selectByVisibleText(inputCase.getStatus().name);
        new CaseDropdown(driver, "Case Origin").selectByVisibleText(inputCase.getCaseOrigin().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputCase.getPriority().name);
        new AccountTextarea(driver, "Description").setValue(inputCase.getDescription());
        new AccountInput(driver, "Subject").setValue(inputCase.getSubject());

    }
    public void fillFormUpdate(Case inputCase) {
        log.debug("Updating Account form");
        new CaseDropdown(driver, "Status").selectByVisibleText(inputCase.getStatus().name);
        new CaseDropdown(driver, "Priority").selectByVisibleText(inputCase.getPriority().name);

    }
}

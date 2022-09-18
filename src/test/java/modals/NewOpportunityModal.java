package modals;

import elements.LightningInput;
import elements.OpportunityCombobox;
import elements.OpportunitySearchInput;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Opportunity;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewOpportunityModal extends BaseModal{

    public NewOpportunityModal(WebDriver driver) {
        super(driver);
    }

    @Step("Filling Opportunity form")
    public void fillForm(Opportunity inputOpportunity) {
        log.debug("Filling new Opportunity form");
        new LightningInput(driver, "Opportunity Name").setValue(inputOpportunity.getOpportunityName());
        new OpportunitySearchInput(driver, "Account Name").setValue(inputOpportunity.getAccountName());
        new LightningInput(driver, "Close Date").setValue(inputOpportunity.getCloseData());
        new OpportunityCombobox(driver, "Stage").selectByVisibleText(inputOpportunity.getStage().name);

    }

}

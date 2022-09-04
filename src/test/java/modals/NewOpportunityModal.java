package modals;

import elements.ContactSearchInput;
import elements.LightningCombobox;
import elements.LightningInput;

import models.Opportunity;
import org.openqa.selenium.WebDriver;

public class NewOpportunityModal extends BaseModal{

    public NewOpportunityModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Opportunity inputOpportunity) {
        new LightningInput(driver, "Opportunity Name").setValue(inputOpportunity.getOpportunityName());
        new ContactSearchInput(driver, "Account Name").setValue(inputOpportunity.getAccountName());
        new LightningInput(driver, "Close Date").setValue(inputOpportunity.getCloseData());
        new LightningCombobox(driver, "Stage").selectByVisibleText(inputOpportunity.getStage().name);

    }

}

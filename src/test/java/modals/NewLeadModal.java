package modals;

import enums.elements.LightningCombobox;
import enums.elements.LightningInput;
import enums.elements.LightningTextarea;
import lombok.extern.log4j.Log4j2;
import models.Lead;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewLeadModal extends BaseModal {

    public NewLeadModal(WebDriver driver) {
        super(driver);
    }

    public void fillForm(Lead inputLead) {

        log.debug("Filling new Lead form");
        new LightningInput(driver, "Last Name").setValue(inputLead.getLastName());
        new LightningCombobox(driver, "Lead Status").selectByVisibleText(inputLead.getLeadStatus().name);
        new LightningInput(driver, "Phone").setValue(inputLead.getPhone());
        new LightningInput(driver, "Company").setValue(inputLead.getCompany());
        new LightningInput(driver, "Title").setValue(inputLead.getTitle());
        new LightningInput(driver, "Email").setValue(inputLead.getEmail());
        new LightningCombobox(driver, "Rating").selectByVisibleText(inputLead.getRating().name);
        new LightningInput(driver, "Website").setValue(inputLead.getWebSite());
        new LightningInput(driver, "No. of Employees").setValue(inputLead.getNumberOfEmployees());
        new LightningInput(driver, "Annual Revenue").setValue(inputLead.getAnnualRevenue());
        new LightningCombobox(driver, "Lead Source").selectByVisibleText(inputLead.getLeadSource().name);
        new LightningCombobox(driver, "Industry").selectByVisibleText(inputLead.getIndustry().name);
        new LightningTextarea(driver, "Description").setValue(inputLead.getDescription());


    }
}

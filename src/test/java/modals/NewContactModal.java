package modals;

import enums.elements.ContactSearchInput;
import enums.elements.LightningInput;
import lombok.extern.log4j.Log4j2;
import models.Contact;
import org.openqa.selenium.WebDriver;

@Log4j2
public class NewContactModal extends BaseModal {

    public NewContactModal(WebDriver driver) {
        super(driver);
    }


    public void fillForm(Contact inputContact) {
        log.debug("Filling new Contact form");
        new LightningInput(driver, "Last Name").setValue(inputContact.getLastName());
        new ContactSearchInput(driver, "Account Name").setValue(inputContact.getAccountName());
        new LightningInput(driver, "Title").setValue(inputContact.getTitle());
        new LightningInput(driver, "Phone").setValue(inputContact.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputContact.getPhone());
        new LightningInput(driver, "Email").setValue(inputContact.getEmail());


    }
}

package modals;

import elements.ContactSearchInput;
import elements.LightningInput;
import models.Contact;
import org.openqa.selenium.WebDriver;

public class NewContactModal extends BaseModal {

    public NewContactModal(WebDriver driver) {
        super(driver);
    }


    public void fillForm(Contact inputContact) {
        new LightningInput(driver, "Last Name").setValue(inputContact.getLastName());
        new ContactSearchInput(driver, "Account Name").setValue(inputContact.getAccountName());
        new LightningInput(driver, "Title").setValue(inputContact.getTitle());
        new LightningInput(driver, "Phone").setValue(inputContact.getPhone());
        new LightningInput(driver, "Mobile").setValue(inputContact.getPhone());
        new LightningInput(driver, "Email").setValue(inputContact.getEmail());


    }
}

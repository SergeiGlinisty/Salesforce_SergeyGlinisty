package tests;

import com.github.javafaker.Faker;
import models.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.ContactsPage;
import pages.modals.NewContactModal;

import static constants.Constants.*;
import static constants.Constants.NewLead.EMAIL;
import static constants.Constants.NewLead.TITLE;

public class ContactTest extends BaseTest {

    @BeforeClass
    public void initialise() {

        contactsPage = new ContactsPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        newContactModal = new NewContactModal(driver);

    }

    @Test
    public void createNewContact() {

        loginPage.setUserName(USERNAME);
        loginPage.setPassword(PASSWORD);
        loginPage.clickLoginButton();
        homePage.waitForPageLoaded();
        homePage.openContactsTab();
        contactsPage.waitForPageLoaded();
        contactsPage.clickNewButton();
        newContactModal.waitForPageLoaded();

        Faker faker = new Faker();

        Contact testContact = new Contact.ContactBuilder(faker.name().lastName(), ACCOUNTNAME)
                .title(TITLE)
                .phone(faker.phoneNumber().phoneNumber())
                .mobile(faker.phoneNumber().phoneNumber())
                .email(EMAIL)
                .build();

        newContactModal.fillForm(testContact);
        newContactModal.clickSaveButton();
        Assert.assertTrue(contactsPage.isPopupPresent());
        Assert.assertEquals(testContact, contactDetailsPage.getLeadInfo());


    }


}

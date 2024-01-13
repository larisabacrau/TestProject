package pom.tests;

import org.junit.Before;
import org.junit.Test;
import pom.testdata.Contact;
import pom.testdata.pages.AddContactTD;

import static org.junit.Assert.assertEquals;

public class ContactTests extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(user);
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @Test
    public void addContactCheck() throws InterruptedException {
        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(contact);

        assertEquals(contact.getFirstName() + " " + contact.getLastName(), contactPage.getNewContactName().getText());
        assertEquals(contact.getEmail(), contactPage.getNewContactEmail().getText());
        assertEquals(contact.getCountry(), contactPage.getNewContactCountry().getText());

        contactPage.openNewContact();
        Thread.sleep(1000);
        deleteContactPage.clickDeleteContact();
        deleteContactPage.clickOkButton();
    }

    @Test
    public void whenAddContactWithoutFirstName_shouldShowFirstNameIsRequired() throws InterruptedException {
        Contact invalidContact = new Contact("addContact_invalid_firstName");

        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(invalidContact);

        Thread.sleep(2000);
        assertEquals(AddContactTD.ADD_CONTACT_FIRST_NAME_ERROR, contactPage.getAddContactError().getText());
    }

    @Test
    public void whenAddContactWithoutLastName_shouldShowLastNameIsRequired() throws InterruptedException {
        Contact invalidContact = new Contact("addContact_invalid_lastName");

        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(invalidContact);

        Thread.sleep(2000);
        assertEquals(AddContactTD.ADD_CONTACT_LAST_NAME_ERROR, contactPage.getAddContactError().getText());
    }

}

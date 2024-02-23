package pom.tests;

import org.junit.Before;
import org.junit.Test;
import pom.testdata.Contact;
import pom.testdata.pages.AddContactTD;

import static org.junit.Assert.assertEquals;

public class AddContactTests extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login(userData);
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @Test
    public void addContactCheck() throws InterruptedException {
        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(contactData);

        assertEquals(contactData.getFirstName() + " " + contactData.getLastName(), contactPage.getNewContactName().getText());
        assertEquals(contactData.getEmail(), contactPage.getNewContactEmail().getText());
        assertEquals(contactData.getCountry(), contactPage.getNewContactCountry().getText());

        contactPage.openNewContact();
        Thread.sleep(1000);
        deleteContactPage.clickDeleteContact();
        deleteContactPage.clickOkButton();
    }

    @Test
    public void whenAddContactWithoutFirstName_shouldShowFirstNameIsRequired() throws InterruptedException {
        contactData.setFirstName("");

        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(contactData);

        Thread.sleep(2000);
        assertEquals(AddContactTD.ADD_CONTACT_FIRST_NAME_ERROR, contactPage.getAddContactError().getText());
    }

    @Test
    public void whenAddContactWithoutLastName_shouldShowLastNameIsRequired() throws InterruptedException {
        contactData.setLastName("");

        contactPage.clickAddNewContactButton();
        contactPage.createNewContact(contactData);

        Thread.sleep(2000);
        assertEquals(AddContactTD.ADD_CONTACT_LAST_NAME_ERROR, contactPage.getAddContactError().getText());
    }

}

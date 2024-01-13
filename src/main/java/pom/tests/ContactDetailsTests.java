package pom.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactDetailsTests extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login("larisabacrau@gmail.com", "Lari0904!@");
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @Test
    public void checkContactDetails() throws InterruptedException {
        contactPage.clickAddNewContactButton();
        contactPage.createNewContact("Larisa Monica", "Andras-Bacrau", "larisabacrau@gmail.com", "Romania");
        contactPage.openNewContact();
        Thread.sleep(1000);
        assertEquals("Larisa Monica", contactDetailsPage.getContactFirstName().getText());
        assertEquals("Andras-Bacrau", contactDetailsPage.getContactLastName().getText());
        assertEquals("larisabacrau@gmail.com", contactDetailsPage.getContactEmail().getText());
        assertEquals("Romania", contactDetailsPage.getContactCountry().getText());
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        deleteContactPage.clickDeleteContact();
        deleteContactPage.clickOkButton();
    }
}

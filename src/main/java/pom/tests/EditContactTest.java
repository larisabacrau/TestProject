package pom.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EditContactTest extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login("larisabacrau@gmail.com", "Lari0904!@");
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @Test
    public void checkEditChange() throws InterruptedException {
        contactPage.clickAddNewContactButton();
        contactPage.createNewContact("Larisa Monica", "Andras-Bacrau", "larisabacrau@gmail.com", "Romania");
        contactPage.openNewContact();
        Thread.sleep(1000);

        contactDetailsPage.clickEditContact();
        assertEquals("Edit Contact", contactDetailsPage.getEditContactHeader().getText());

        editContactPage.replaceFirstName("edit first name");
        editContactPage.replaceLastName("edit last name");
        editContactPage.clickSubmitButton();
        Thread.sleep(1000);
        assertEquals("edit first name", editContactPage.getFirstName().getText());
        assertEquals("edit last name", editContactPage.getLastName().getText());
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(1000);
        deleteContactPage.clickDeleteContact();
        deleteContactPage.clickOkButton();
    }
}

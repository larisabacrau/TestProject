package pom.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class DeleteContactTest extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        loginPage.login("larisabacrau@gmail.com", "Lari0904!@");
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    @Test
    public void deleteContactCheck() throws InterruptedException {
        contactPage.clickAddNewContactButton();
        contactPage.createNewContact("Larisa Monica", "Andras-Bacrau", "larisabacrau@gmail.com", "Romania");
        contactPage.openNewContact();
        Thread.sleep(1000);
        deleteContactPage.clickDeleteContact();
        deleteContactPage.clickOkButton();
        assertFalse(deleteContactPage.getContactTable().getText().contains("larisabacrau@gmail.com"));
    }
}

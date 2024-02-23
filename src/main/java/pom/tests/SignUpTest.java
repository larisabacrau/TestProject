package pom.tests;

import org.junit.Before;
import org.junit.Test;
import pom.testdata.pages.SignUpTD;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    @Before
    @Override
    public void before() {
        super.before();
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com/addUser");
    }

    @Test
    public void signUpTest() {
        signUpPage.signUp(signUpData);
        assertEquals("Logout", signUpPage.findLogoutButton().getText());
    }
    @Test
    public void whenSignUpWithoutFirstName_shouldFirstNameRequired() throws InterruptedException {
        signUpData.setFirstName("");

        signUpPage.signUp(signUpData);
        Thread.sleep(1000);
        assertEquals(SignUpTD.FIRST_NAME_ERROR,signUpPage.getErrorMessage().getText());

    }
    @Test
    public void whenSignUpWithoutLastname_shouldLastNameRequired() throws InterruptedException {
        signUpData.setLastName("");

        signUpPage.signUp(signUpData);
        Thread.sleep(1000);
        assertEquals(SignUpTD.LAST_NAME_ERROR, signUpPage.getErrorMessage().getText());

    }

    @Test
    public void whenSignUpWithoutEmail_shouldEmailIsInvalid() throws InterruptedException {
        signUpData.setEmail("");

        signUpPage.signUp(signUpData);
        Thread.sleep(1000);
        assertEquals(SignUpTD.EMAIL_ERROR,signUpPage.getErrorMessage().getText());
    }
}

package pom.tests;

import org.junit.Before;
import org.junit.Test;
import pom.testdata.pages.SignUp;
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
        signUpPage.signUp(signUp);
        assertEquals("Logout", signUpPage.findLogoutButton().getText());
    }
    @Test
    public void whenSignUpWithoutFirstName_shouldFirstNameRequired() throws InterruptedException {
        SignUp invalidSignUp1 = new SignUp("signup_invalid_firstName");

        signUpPage.signUp(invalidSignUp1);
        Thread.sleep(1000);
        assertEquals(SignUpTD.FIRST_NAME_ERROR,signUpPage.getErrorMessage().getText());

    }
    @Test
    public void whenSignUpWithoutLastname_shouldLastNameRequired() throws InterruptedException {
        SignUp invalidSignUp2 = new SignUp("signup_invalid_lastName");

        signUpPage.signUp(invalidSignUp2);
        Thread.sleep(1000);
        assertEquals(SignUpTD.LAST_NAME_ERROR, signUpPage.getErrorMessage().getText());

    }

    @Test
    public void whenSignUpWithoutEmail_shouldEmailIsInvalid() throws InterruptedException {
        SignUp invalidSignUp3 = new SignUp("signup_invalid_email");

        signUpPage.signUp(invalidSignUp3);
        Thread.sleep(1000);
        assertEquals(SignUpTD.EMAIL_ERROR,signUpPage.getErrorMessage().getText());
    }
}

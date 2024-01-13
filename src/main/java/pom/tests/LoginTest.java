package pom.tests;

import org.junit.Test;
import pom.testdata.User;
import pom.testdata.pages.LoginTD;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        loginPage.login(user);
        assertEquals("Logout", signUpPage.findLogoutButton().getText());
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        User invalidUser = new User("login_invalid");
        loginPage.login(invalidUser);

        //alternativa explicit wait in loc de thread sleep
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorLocator()));
        Thread.sleep(1000);
        assertEquals(LoginTD.LOGIN_ERROR_MESSAGE, loginPage.getErrorMessage().getText());
    }
}

package pom.tests;

import org.junit.Test;
import pom.pages.LoginPage;
import pom.testdata.User;
import pom.testdata.pages.LoginTD;
import utils.RandomGenerator;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        loginPage.login(userData);
        assertEquals("Logout", signUpPage.findLogoutButton().getText());
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        userData.setEmail(RandomGenerator.stringValue(6));
        userData.setPassword(RandomGenerator.stringValue(6));
        loginPage.login(userData);

        //alternativa explicit wait in loc de thread sleep
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getErrorLocator()));
        Thread.sleep(1000);
        assertEquals(LoginTD.LOGIN_ERROR_MESSAGE, loginPage.getErrorMessage().getText());
    }
}

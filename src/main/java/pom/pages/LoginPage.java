package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.testdata.User;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By error = By.id("error");

    public By getErrorLocator() {
        return error;
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(error);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }

    public void login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickSubmit();
    }
}

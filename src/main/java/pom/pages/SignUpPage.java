package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.testdata.pages.SignUp;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {

        this.driver = driver;
    }


    private By signupButton = By.id("signup");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By emailInput = By.id("email");
    private By passwordInput = By.id("password");
    private By submitButton = By.id("submit");
    private By logoutButton = By.id("logout");
    private By errorMessage = By.id("error");


    public void clickSignUp() {

        driver.findElement(signupButton).click();
    }

    public void enterFirstName(String firstname) {
        driver.findElement(firstName).sendKeys(firstname);
    }
    public void enterLastName(String lastname) {
        driver.findElement(lastName).sendKeys(lastname);
    }
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void enterPassword (String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();


    }

    public WebElement findLogoutButton() {
        return driver.findElement(By.id("logout"));
    }

    public void signup(String firstname, String lastname, String email, String password) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
    }
    public void signUp(SignUp signUp) {
        enterFirstName(signUp.getFirstName());
        enterLastName(signUp.getLastName());
        enterEmail(signUp.getEmail());
        enterPassword(signUp.getPassword());
        clickSubmit();
    }

    public WebElement getErrorMessage(){
        return driver.findElement(errorMessage);
    }
}

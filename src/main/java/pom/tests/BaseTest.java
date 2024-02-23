package pom.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pom.pages.*;
import pom.testdata.Contact;
import pom.testdata.User;
import pom.testdata.SignUp;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;

    public SignUpPage signUpPage;
    public LoginPage loginPage;
    public ContactPage contactPage;
    public ContactDetailsPage contactDetailsPage;
    public EditContactPage editContactPage;
    public DeleteContactPage deleteContactPage;

    public User userData = new User("login_valid");
    public Contact contactData = new Contact("addContact_valid");
    public SignUp signUpData = new SignUp();

    @After
    public void tearDown() {
        driver.close();
    }

    @Before
    public void before() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", "ignore-certificate-errors");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);
        //wait implicit
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        contactPage = new ContactPage(driver);
        contactDetailsPage = new ContactDetailsPage(driver);
        editContactPage = new EditContactPage(driver);
        deleteContactPage = new DeleteContactPage(driver);
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
    }
}

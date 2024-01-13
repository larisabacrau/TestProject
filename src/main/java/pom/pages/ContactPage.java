package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.testdata.Contact;

public class ContactPage {
    WebDriver driver;
    private By addNewContactButton = By.id("add-contact");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By emailInput = By.id("email");
    private By countryInput = By.id("country");
    private By submitButton = By.id("submit");
    private By newContactName = By.xpath("//tr[@class=\"contactTableBodyRow\"][last()]/descendant::td[2]");
    private By newContactEmail = By.xpath("//tr[@class=\"contactTableBodyRow\"][last()]/descendant::td[4]");
    private By newContactCountry = By.xpath("//tr[@class=\"contactTableBodyRow\"][last()]/descendant::td[8]");
    private By addContactError = By.id("error");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddNewContactButton() {
        driver.findElement(addNewContactButton).click();
    }

    public void clickSubmit() {
        driver.findElement(By.id("submit")).click();
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

    public void enterCountry(String country) {
        driver.findElement(countryInput).sendKeys(country);
    }

    public WebElement getNewContactName() {
        return driver.findElement(newContactName);
    }

    public WebElement getNewContactEmail() {
        return driver.findElement(newContactEmail);
    }

    public WebElement getNewContactCountry() {
        return driver.findElement(newContactCountry);
    }

    public void openNewContact() {
        getNewContactName().click();
    }


    public void createNewContact(String firstname, String lastname, String email, String country) {
        enterFirstName(firstname);
        enterLastName(lastname);
        enterEmail(email);
        enterCountry(country);
        clickSubmit();
    }

    public void createNewContact(Contact contact) {
        enterFirstName(contact.getFirstName());
        enterLastName(contact.getLastName());
        enterEmail(contact.getEmail());
        enterCountry(contact.getCountry());
        clickSubmit();
    }

    public WebElement getAddContactError() {
        return driver.findElement(addContactError);
    }
}

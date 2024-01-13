package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactDetailsPage {
    WebDriver driver;

    public ContactDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    private By contactFirstName = By.id("firstName");
    private By contactLastName = By.id("lastName");
    private By contactEmail = By.id("email");
    private By contactCountry = By.id("country");
    private By editContact = By. id("edit-contact");
    private By deleteContact = By.id("delete");
    private By editContactHeader = By.xpath("//h1[contains(text(),\"Edit Contact\")]");


    public WebElement getContactFirstName() {
        return driver.findElement(contactFirstName);
    }
    public WebElement getContactLastName() {
        return driver.findElement(contactLastName);
    }
    public WebElement getContactEmail() {
        return driver.findElement(contactEmail);
    }
    public WebElement getContactCountry() {
        return driver.findElement(contactCountry);
    }
    public void clickEditContact() {
        driver.findElement(editContact).click();
    }
    public void clickDeleteContact() {
        driver.findElement(deleteContact).click();
    }
    public WebElement getEditContactHeader() {
        return driver.findElement(editContactHeader);
    }
}

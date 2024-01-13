package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditContactPage {
    WebDriver driver;

    public EditContactPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.xpath("//input[@id=\"firstName\"]");
    private By lastNameInput = By.xpath("//input[@id=\"lastName\"]");
    private By firstNameDetail = By.id("firstName");
    private By lastNameDetail = By.id("lastName");

    private By submitButton = By.id("submit");

    public void replaceFirstName(String update) {
        driver.findElement(firstNameInput).sendKeys(update);
    }
    public void replaceLastName(String update) {
        driver.findElement(lastNameInput).sendKeys(update);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameDetail);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameDetail);
    }
}

package pom.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteContactPage {
    WebDriver driver;
    private final By deleteContactButton = By.id("delete");
    private final By contactTable = By.xpath("//table[@class=\"contactTable\"]");

    public DeleteContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteContact() {
        driver.findElement(deleteContactButton).click();
    }

    public void clickOkButton() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public WebElement getContactTable() {
        return driver.findElement(contactTable);
    }


}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabCheckout {
    private WebDriver driver;
    public SwagLabCheckout(WebDriver driver){this.driver=driver;}

    By firstNameField = By.xpath("//input[@data-test='firstName']");
    By lastNameField = By.xpath("//input[@data-test='lastName']");
    By zipCodeField = By.xpath("//input[@data-test='postalCode']");
    By continueButton = By.xpath("//input[@data-test='continue']");
    By totalPrice = By.xpath("//div[@class='summary_subtotal_label']");

    public void inputFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void inputLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void inputZipCode(String zipCode){
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }

    public String getTotalPrice(){
        return driver.findElement(totalPrice).getText();
    }
}

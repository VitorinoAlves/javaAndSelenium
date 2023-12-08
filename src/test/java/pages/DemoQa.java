package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQa {
    private WebDriver driver;
    public DemoQa(WebDriver driver){this.driver=driver;}

    By loginButton = By.xpath("//button[@id='login']");
    By usernameField = By.xpath("//input[@id='userName']");
    By passwordField = By.xpath("//input[@id='password']");
    By usernameHomeLabel = By.xpath("//label[@id='userName-value']");
    By addToYourCollectionButton = By.xpath("//button[text()='Add To Your Collection']");
    By profileMenuOption = By.xpath("//span[text()='Profile']/..");
    By deleteIcon = By.xpath("//span[@id='delete-record-undefined']");
    By confirmDeleteActionButton = By.xpath("//button[@id='closeSmallModal-ok']");

    public void performLoginAction(String username, String password){
        driver.findElement(loginButton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getUserNameHome(){
        return driver.findElement(usernameHomeLabel).getText();
    }
}

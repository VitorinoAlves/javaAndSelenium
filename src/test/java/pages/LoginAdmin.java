package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginAdmin {
    WebDriver driver;

    public LoginAdmin(WebDriver driver){
        this.driver=driver;
    }

    By usernameField = By.xpath("//label[contains(text(),'Username')]/..//input");
    By passwordField = By.xpath("//label[contains(text(),'Password')]/..//input");
    By loginButton = By.xpath("//button[@type='submit']");

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clockLogin(){
        driver.findElement(loginButton).click();
    }


}

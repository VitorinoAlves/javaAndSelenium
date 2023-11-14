package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabLogin {

    private WebDriver driver;

    public SwagLabLogin(WebDriver driver){this.driver=driver;}

    By usernameField = By.xpath("//input[@id='user-name']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//input[@id='login-button']");
    By alertMessage = By.xpath("//h3[@data-test='error']");

    public void inputUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getAlertText(){
        return driver.findElement(alertMessage).getText();
    }

    public void login(String username, String password){
        this.inputUsername(username);
        this.inputPassword(password);
        this.clickLoginButton();
    }
}

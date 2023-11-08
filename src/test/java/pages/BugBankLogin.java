package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugBankLogin {
    private WebDriver driver;

    public BugBankLogin(WebDriver driver){this.driver=driver;}

    By registrarButton = By.xpath("//button[contains(text(),'Registrar')]");
    By emailLoginField = By.xpath("//div[@class='card__login']//input[@type='email']");
    By passwordLoginField = By.xpath("//div[@class='card__login']//input[@name='password']");
    By loginButton = By.xpath("//div[@class='login__buttons']//button[@type='submit']");

    public void clickRegistrarButton(){
        driver.findElement(registrarButton).click();
    }

    public void inputEmail(String email){
        driver.findElement(emailLoginField).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(passwordLoginField).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }


}

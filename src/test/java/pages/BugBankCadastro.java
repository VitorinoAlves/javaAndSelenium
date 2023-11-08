package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BugBankCadastro {
    private WebDriver driver;

    public BugBankCadastro(WebDriver driver){this.driver=driver;}

    By emailField = By.xpath("//div[@class='card__register']//input[@type='email']");
    By nameField = By.xpath("//div[@class='card__register']//input[@type='name']");
    By passwordField = By.xpath("//div[@class='card__register']//input[@name='password']");
    By confirmPasswordField = By.xpath("//div[@class='card__register']//input[@name='passwordConfirmation']");
    By comSaldoToggle = By.xpath("//label[@id='toggleAddBalance']");
    By cadastrarButton = By.xpath("//button[contains(text(),'Cadastrar')]");
    By mensagemDeSucesso = By.xpath("//p[@id='modalText']");

    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputName(String name){
        driver.findElement(nameField).sendKeys(name);
    }

    public void inputNewPassword(String newPassword){
        driver.findElement(passwordField).sendKeys(newPassword);
    }

    public void inputConfirmPassword(String confirmPassword){
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }

    public void checkComSaldo(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(comSaldoToggle));
    }

    public void clickCadastrarButton(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(cadastrarButton));
    }

}

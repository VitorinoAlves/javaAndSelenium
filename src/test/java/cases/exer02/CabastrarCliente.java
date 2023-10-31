package cases.exer02;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CabastrarCliente {

    /*Realizar o registro de um cliente selecionando a opção de criar um conta com saldo e validar que o número da conta criada foi exibido com sucesso*/
    @Test
    public void cadastrarNovoCliente(){
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bugbank.netlify.app/");

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email = "username"+ randomInt +"@gmail.com";

        By registrarButton = By.xpath("//button[contains(text(),'Registrar')]");
        By emailField = By.xpath("//div[@class='card__register']//input[@type='email']");
        By nameField = By.xpath("//div[@class='card__register']//input[@type='name']");
        By passwordField = By.xpath("//div[@class='card__register']//input[@name='password']");
        By confirmPasswordField = By.xpath("//div[@class='card__register']//input[@name='passwordConfirmation']");
        By comSaldoToggle = By.xpath("//label[@id='toggleAddBalance']");
        By cadastrarButton = By.xpath("//button[contains(text(),'Cadastrar')]");

        driver.findElement(registrarButton).click();
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nameField).sendKeys("Carlos Test");
        driver.findElement(passwordField).sendKeys("password01");
        driver.findElement(confirmPasswordField).sendKeys("password01");
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(comSaldoToggle));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", driver.findElement(cadastrarButton));
    }
}

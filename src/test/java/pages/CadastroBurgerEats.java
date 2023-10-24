package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CadastroBurgerEats {
    private WebDriver driver;

    public CadastroBurgerEats(WebDriver driver){this.driver=driver;}

    private final By nomeCompletoField = By.xpath("//input[@name='name']");
    private final By cpfField = By.xpath("//input[@name='cpf']");
    private final By emailField = By.xpath("//input[@name='email']");
    private final By whatsappField = By.xpath("//input[@name='whatsapp']");
    private final By cepField = By.xpath("//input[@name='postalcode']");
    private final By buscarCepButton = By.xpath("//input[@value='Buscar CEP']");
    private final By ruaField = By.xpath("//input[@name='address']");
    private final By numeroField = By.xpath("//input[@name='address-number']");
    private final By complementoField = By.xpath("//input[@name='address-details']");
    private final By bairroField = By.xpath("//input[@name='district']");
    private final By cidadeUfField = By.xpath("//input[@name='city-uf']");
    private final By motoButton = By.xpath("//img[@alt='Moto']");
    private final By bicicletaButton = By.xpath("//img[@alt='Bicicleta']");
    private final By vanButton = By.xpath("//img[@alt='Van/Carro']");
    private final By fotoCnhField = By.xpath("//div[@class='dropzone']/input");
    private final By cadastroButton = By.xpath("//button[@type='submit']");

    public void inputCompleteName(String name){
        driver.findElement(nomeCompletoField).sendKeys(name);
    }

    public void inputCpf(String cpf){
        driver.findElement(cpfField).sendKeys(cpf);
    }

}

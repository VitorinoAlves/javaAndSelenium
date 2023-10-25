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

    //Mensagens
    private final By cpfInvalidoAlert = By.xpath("//input[@name='cpf']/../span");
    private final By fotoCnhObrigatoriaAlert = By.xpath("//div[@class='dropzone']/../span");
    private final By mensagenDeSucesso = By.xpath("//div[@id='swal2-html-container']");

    public void inputCompleteName(String name){
        driver.findElement(nomeCompletoField).sendKeys(name);
    }

    public void inputCpf(String cpf){
        driver.findElement(cpfField).sendKeys(cpf);
    }

    public void inputEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void inputWhatsapp(String whatsapp){
        driver.findElement(whatsappField).sendKeys(whatsapp);
    }

    public void inputCep(String cep){
        driver.findElement(cepField).sendKeys(cep);
    }

    public void inputNumeroEndereco(String numeroEndereco){
        driver.findElement(numeroField).sendKeys(numeroEndereco);
    }

    public void inputComplemento(String complemento){
        driver.findElement(complementoField).sendKeys(complemento);
    }

    public void clickBuscarCepButton(){
        driver.findElement(buscarCepButton).click();
    }

    public void selecionaOpcaoMoto(){
        driver.findElement(motoButton).click();
    }

    public void clickSubmitButton(){
        driver.findElement(cadastroButton).click();
    }

    public String getcpfInvalidoAlert(){
        return driver.findElement(cpfInvalidoAlert).getText();
    }

    public String getCnhObrigatoriaAlert(){
        return driver.findElement(fotoCnhObrigatoriaAlert).getText();
    }

    public String getMensagemDeSucesso(){
        return driver.findElement(mensagenDeSucesso).getText();
    }

}

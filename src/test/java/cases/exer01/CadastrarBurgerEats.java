package cases.exer01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroBurgerEats;
import pages.HomeBugerEats;
import org.openqa.selenium.By;
import pages.LoginAdmin;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastrarBurgerEats {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://buger-eats.vercel.app/");
    }

    @AfterEach
    public void tearDown(){
        //driver.close();
        driver.quit();
    }

    /*Efetue uma tentativa de cadastro informando
    um CPF inválido e deixando de enviar a foto da CNH e valide que mensagens informando
    da necessidade de corrigir os campos são exibidas.*/
    @Test
    public void cadastroInvalido(){
        HomeBugerEats homeBugerEats = new HomeBugerEats(driver);
        CadastroBurgerEats cadastroBurgerEats = new CadastroBurgerEats(driver);

        homeBugerEats.clickOnCadastrarButton();
        cadastroBurgerEats.inputCompleteName("Carlos Alexandre");
        cadastroBurgerEats.inputCpf("123456789051");
        cadastroBurgerEats.inputEmail("test@test.com");
        cadastroBurgerEats.inputWhatsapp("1234567890");
        cadastroBurgerEats.inputCep("49045-290");
        cadastroBurgerEats.inputNumeroEndereco("152");
        cadastroBurgerEats.inputComplemento("Complemento");
        cadastroBurgerEats.selecionaOpcaoMoto();
        cadastroBurgerEats.clickSubmitButton();

        assertEquals("Oops! CPF inválido", cadastroBurgerEats.getcpfInvalidoAlert());
    }

    /*Efetue um cadastro completo, informando os dados necessários corretamente, selecionando o
    método de entrega “Bicicleta” (porque somos amigos da natureza 😀🚲).
    Valide que o cadastro foi concluído com sucesso.*/
    @Test
    public void cadastroValido(){
        HomeBugerEats homeBugerEats = new HomeBugerEats(driver);
        CadastroBurgerEats cadastroBurgerEats = new CadastroBurgerEats(driver);
        Path path = Paths.get("src/test/resources/test.png");
        File imagePath = new File(path.toUri());

        homeBugerEats.clickOnCadastrarButton();
        cadastroBurgerEats.inputCompleteName("Carlos Alexandre");
        cadastroBurgerEats.inputCpf("39642979098");
        cadastroBurgerEats.inputEmail("test@test.com");
        cadastroBurgerEats.inputWhatsapp("39642979098");
        cadastroBurgerEats.inputCep("49045-290");
        cadastroBurgerEats.clickBuscarCepButton();
        cadastroBurgerEats.inputNumeroEndereco("152");
        cadastroBurgerEats.inputComplemento("Complemento");
        cadastroBurgerEats.selecionaOpcaoMoto();
        driver.findElement(By.xpath("//div[@class='dropzone']/input")).sendKeys(imagePath.toString());
        driver.findElement(By.xpath("//div[@class='dropzone']/input")).submit();
        //cadastroBurgerEats.clickSubmitButton();

        assertEquals("Recebemos os seus dados. Fique de olho na sua caixa de email, pois e em breve retornamos o contato.", cadastroBurgerEats.getMensagemDeSucesso());
    }
}

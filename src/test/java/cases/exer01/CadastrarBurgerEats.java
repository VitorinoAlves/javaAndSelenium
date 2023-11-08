package cases.exer01;

import org.junit.jupiter.api.Test;
import pages.CadastroBurgerEats;
import pages.HomeBugerEats;
import org.openqa.selenium.By;
import utils.Driver;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CadastrarBurgerEats extends Driver {
    /*Efetue uma tentativa de cadastro informando
    um CPF inválido e deixando de enviar a foto da CNH e valide que mensagens informando
    da necessidade de corrigir os campos são exibidas.*/
    @Test
    public void cadastroInvalido(){
        driver.get("https://buger-eats.vercel.app/");
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
        driver.get("https://buger-eats.vercel.app/");
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

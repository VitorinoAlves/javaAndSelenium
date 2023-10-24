package cases.exer01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CadastroBurgerEats;
import pages.HomeBugerEats;

public class CadastrarBurgerEats {

    /*Efetue uma tentativa de cadastro informando
    um CPF inválido e deixando de enviar a foto da CNH e valide que mensagens informando
    da necessidade de corrigir os campos são exibidas.*/
    @Test
    public void cadastroInvalido(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://buger-eats.vercel.app/");
        HomeBugerEats homeBugerEats = new HomeBugerEats(driver);
        CadastroBurgerEats cadastroBurgerEats = new CadastroBurgerEats(driver);

        homeBugerEats.clickOnCadastrarButton();
        cadastroBurgerEats.inputCompleteName("Carlos Alexandre");
        cadastroBurgerEats.inputCpf("12345678901");


        driver.quit();
    }
}

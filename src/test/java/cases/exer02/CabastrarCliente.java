package cases.exer02;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BugBankCadastro;
import pages.BugBankExtrato;
import pages.BugBankHome;
import pages.BugBankLogin;
import utils.DataGenerator;
import utils.Driver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabastrarCliente {
    public static WebDriver driver;
    static DataGenerator dataGenerator = new DataGenerator();
    static String email;

    @BeforeAll
    public static void setUpOnce(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        email = dataGenerator.emailGenarator();
    }

    @AfterAll
    public static void quitDriver(){
        driver.quit();
    }

    /*Realizar o registro de um cliente selecionando a opção de criar um conta com saldo e validar que o número da conta criada foi exibido com sucesso*/
    @Test
    public void cadastrarNovoCliente(){
        BugBankLogin bugBankLogin = new BugBankLogin(driver);
        BugBankCadastro bugBankCadastro = new BugBankCadastro(driver);
        driver.get("https://bugbank.netlify.app/");

        bugBankLogin.clickRegistrarButton();
        bugBankCadastro.inputEmail(email);
        bugBankCadastro.inputName("Carlos Test");
        bugBankCadastro.inputNewPassword("password01");
        bugBankCadastro.inputConfirmPassword("password01");
        bugBankCadastro.checkComSaldo();
        bugBankCadastro.clickCadastrarButton();
    }

    /*Acessar o BugBak com o cliente criado e verificar que o acesso foi feito com sucesso*/
    @Test
    public void loginIntoBugBak(){
        BugBankLogin bugBankLogin = new BugBankLogin(driver);
        BugBankHome bugBankHome = new BugBankHome(driver);
        driver.get("https://bugbank.netlify.app/");

        bugBankLogin.inputEmail(email);
        bugBankLogin.inputPassword("password01");
        bugBankLogin.clickLoginButton();
        assertEquals("Olá Carlos Test,", bugBankHome.getUserNameLabel());
    }

    /*Obter um extrato da movimentação da conta*/
    @Test
    public void gerarExtrato(){
        BugBankLogin bugBankLogin = new BugBankLogin(driver);
        BugBankHome bugBankHome = new BugBankHome(driver);
        BugBankExtrato bugBankExtrato = new BugBankExtrato(driver);
        driver.get("https://bugbank.netlify.app/");

        bugBankLogin.inputEmail(email);
        bugBankLogin.inputPassword("password01");
        bugBankLogin.clickLoginButton();
        bugBankHome.clickExtratoButton();
        assertEquals("Saldo adicionado ao abrir conta", bugBankExtrato.getDepositoInicialDescricao());
        assertEquals("R$ 1.000,00", bugBankExtrato.getDepositoInicialValor());
    }

}

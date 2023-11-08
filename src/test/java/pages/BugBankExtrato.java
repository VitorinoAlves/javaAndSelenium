package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugBankExtrato {
    private WebDriver driver;

    public BugBankExtrato(WebDriver driver){this.driver=driver;}

    By depositoInicialDescricaoLocator = By.xpath("//p[@id='textDescription']");
    By depositoInicialValorLocator = By.xpath("//p[@id='textTransferValue']");

    public String getDepositoInicialDescricao(){
        return driver.findElement(depositoInicialDescricaoLocator).getText();
    }

    public String getDepositoInicialValor(){
        return driver.findElement(depositoInicialValorLocator).getText();
    }
}

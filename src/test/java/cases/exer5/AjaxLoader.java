package cases.exer5;

import org.junit.jupiter.api.Test;
import pages.Webdriveruniversity;
import utils.DataGenerator;
import utils.Driver;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AjaxLoader extends Driver {

    /*Aguardar o carregamento, clicar no Botão Click me! E clicar em Done na message box que abre*/
    @Test
    public void clickButton(){
        driver.get("http://webdriveruniversity.com");
        Webdriveruniversity webdriveruniversity = new Webdriveruniversity(driver);
        DataGenerator dataGenerator = new DataGenerator();

        webdriveruniversity.clickAjaxLink();
        dataGenerator.switchTab(1, driver);

        webdriveruniversity.clickOnClickMeButton();
        webdriveruniversity.closeModal();
    }

    /*Abrir a página, acessar o for me contact us, preencher e enviar*/
    @Test
    public void iframe(){
        driver.get("http://webdriveruniversity.com");
        Webdriveruniversity webdriveruniversity = new Webdriveruniversity(driver);
        DataGenerator dataGenerator = new DataGenerator();

        webdriveruniversity.clickIframeLink();
        dataGenerator.switchTab(1,driver);

        webdriveruniversity.switchToIframe();
        webdriveruniversity.sendMessage("TestFirstName", "TestLastName", "test@test.com", "Comments...");

        assertEquals("Thank You for your Message!", webdriveruniversity.getMessageSentText());
    }

    /*Date picker*/
    @Test
    public void datePicker(){
        driver.get("http://webdriveruniversity.com");
        Webdriveruniversity webdriveruniversity = new Webdriveruniversity(driver);
        DataGenerator dataGenerator = new DataGenerator();
        Instant yesterday = Instant.now().minus(1, ChronoUnit.DAYS);


        webdriveruniversity.clickDatePickerLink();
        dataGenerator.switchTab(1,driver);

        webdriveruniversity.clickOnDatePickerField();
        webdriveruniversity.selectDateDatePicker(yesterday);
        System.out.println("TEST");
    }
}

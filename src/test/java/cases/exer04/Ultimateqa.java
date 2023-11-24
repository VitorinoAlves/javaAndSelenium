package cases.exer04;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.UltimateHome;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Ultimateqa extends Driver {
    /*Localize o componente Clickable Icon e validar o redirecionamento para a próxima página e voltar para a home*/
    @Test
    public void accessClickableIcon(){
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ultimateHome.clickClickableIcon();
        assertEquals(ultimateHome.getLinkSuccessPageTitle(), "Link success");
    }

    /*Preencher o contato e validar a mensagem de Thanks for contacting us*/
    @Test
    public void informContactData() throws InterruptedException {
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ultimateHome.inputContactName("Test");
        ultimateHome.inputContactEamil("test@test.com");
        Thread.sleep(1000);
        ultimateHome.clickOnEmailMeButton();

        assertEquals(ultimateHome.getEmailSentMessage(), "Thanks for contacting us");

    }
}

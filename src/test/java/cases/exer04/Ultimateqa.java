package cases.exer04;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.UltimateHome;
import utils.Driver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Thread.sleep(2000);
        ultimateHome.clickOnEmailMeButton();

        assertEquals(ultimateHome.getEmailSentMessage(), "Thanks for contacting us");

    }

    /*Selecionar um radio button (male, female, other)*/
    @Test
    public void selectOneRadioButton() throws InterruptedException{
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ultimateHome.clickOnFemaleRadioButton();
        Thread.sleep(500);
        assertTrue(ultimateHome.getFemaleRadioButtonStatus());
    }

    /*Selecionar os checkbox I have a bike e I have a car*/
    @Test
    public void selectCheckboxes() throws InterruptedException{
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ultimateHome.checkIHaveBikeCheckbox();
        ultimateHome.checkIHaveCarCheckbox();
        Thread.sleep(500);
        assertTrue(ultimateHome.getIHaveBikeCheckboxStatus());
        assertTrue(ultimateHome.getIHaveCarCheckboxStatus());
    }

    /*Selecionar dropdown Saab depois selecionar Audi*/
    @Test
    public void selectOptionsDropdown(){
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");

        ultimateHome.selectCar("saab");
        ultimateHome.selectCar("audi");
        assertEquals(ultimateHome.getSelectedOption(), "Audi");
    }

    /*Selecionar Tab 2 Validar seu conteúdo
        Selecionar tab 1 validar seu conteúdo
    */
    @Test
    public void changeTab() throws InterruptedException{
        UltimateHome ultimateHome = new UltimateHome(driver);
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement tabTwoOption = driver.findElement(By.xpath("//li[@class='et_pb_tab_1']/a"));
        WebElement tabTwoContent = driver.findElement(By.xpath("//div[contains(text(),'Tab 2 content')]"));
        WebElement tabOneContent = driver.findElement(By.xpath("//div[contains(text(),'tab 1 content')]"));


        driver.findElement(By.xpath("//div[@class='et_pb_tab_content']")).click();
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//ul[@class='et_pb_tabs_controls clearfix']")));
        Thread.sleep(2000);

        tabTwoOption.click();
        Thread.sleep(1000);
        assertTrue(tabTwoContent.isDisplayed());

        WebElement tabOneOption = driver.findElement(By.xpath("//li[@class='et_pb_tab_0']/a"));
        tabOneOption.click();
        Thread.sleep(1000);
        assertTrue(tabOneContent.isDisplayed());
    }
}

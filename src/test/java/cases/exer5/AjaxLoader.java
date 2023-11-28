package cases.exer5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AjaxLoader extends Driver {

    /*Aguardar o carregamento, clicar no Botão Click me! E clicar em Done na message box que abre*/
    @Test
    public void clickButton(){
        driver.get("http://webdriveruniversity.com");
        String originalWindow = driver.getWindowHandle();

        By ajaxLink = By.xpath("//a[@id='ajax-loader']");
        By clickMeButton = By.xpath("//span[@id='button1']");
        By modalCloseButton = By.xpath("//div[@id='myModalClick']//div[@class='modal-footer']//button");

        driver.findElement(ajaxLink).click();


        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> driver.findElement(clickMeButton).isDisplayed());

        driver.findElement(clickMeButton).click();
        driver.findElement(modalCloseButton).click();
    }

    /*Abrir a página, acessar o for me contact us, preencher e enviar*/
    @Test
    public void iframe(){
        driver.get("http://webdriveruniversity.com");
        String originalWindow = driver.getWindowHandle();

        By iframeLink = By.xpath("//a[@id='iframe']");
        By mainIframe = By.xpath("//iframe");
        By contactUsOption = By.xpath("//*[contains(text(),'Contact Us')]");
        By firstNameField = By.xpath("//input[@name='first_name']");
        By lastNameField = By.xpath("//input[@name='last_name']");
        By emailField = By.xpath("//input[@name='email']");
        By commentsField = By.xpath("//textarea[@name='message']");
        By submitButton = By.xpath("//input[@type='submit']");
        By successMessage = By.xpath("//div[@id='contact_reply']");


        driver.findElement(iframeLink).click();


        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement iframe = driver.findElement(mainIframe);
        driver.switchTo().frame(iframe);
        driver.findElement(contactUsOption).click();

        driver.findElement(firstNameField).sendKeys("TestFirstName");
        driver.findElement(lastNameField).sendKeys("TestLastName");
        driver.findElement(emailField).sendKeys("test@test.com");
        driver.findElement(commentsField).sendKeys("Comments...");
        driver.findElement(submitButton).click();

        assertEquals("Thank You for your Message!", driver.findElement(successMessage).getText());
    }

    @Test
    public void datePicker(){
        driver.get("http://webdriveruniversity.com");
        String originalWindow = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String PATTERN_FORMAT = "MMddyyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        By datePicker = By.xpath("//a[@id='datepicker']");
        By datePickerField = By.xpath("//div[@id='datepicker']/input");

        driver.findElement(datePicker).click();


        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }


        Instant yesterday = Instant.now().minus(1, ChronoUnit.DAYS);
        String formattedYesterday = formatter.format(yesterday);

        js.executeScript("arguments[0].value="+formattedYesterday+";", driver.findElement(datePickerField));
        System.out.println("");
        //https://stackoverflow.com/questions/21422548/how-to-select-the-date-picker-in-selenium-webdriver

    }
}

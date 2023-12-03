package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Webdriveruniversity {
    private WebDriver driver;
    public Webdriveruniversity(WebDriver driver){this.driver=driver;}

    //Home page links
    By ajaxLink = By.xpath("//a[@id='ajax-loader']");
    By iframeLink = By.xpath("//a[@id='iframe']");
    By datePickerLink = By.xpath("//a[@id='datepicker']");

    //Ajax Elements
    By clickMeButton = By.xpath("//span[@id='button1']");
    By modalCloseButton = By.xpath("//div[@id='myModalClick']//div[@class='modal-footer']//button");

    //iFrame elements
    By mainIframe = By.xpath("//iframe");
    By contactUsOption = By.xpath("//*[contains(text(),'Contact Us')]");
    By firstNameField = By.xpath("//input[@name='first_name']");
    By lastNameField = By.xpath("//input[@name='last_name']");
    By emailField = By.xpath("//input[@name='email']");
    By commentsField = By.xpath("//textarea[@name='message']");
    By submitButton = By.xpath("//input[@type='submit']");
    By successMessage = By.xpath("//div[@id='contact_reply']");
    //DatePicker
    By datePickerField = By.xpath("//div[@id='datepicker']/input");


    public void clickAjaxLink(){
        driver.findElement(ajaxLink).click();
    }

    public void clickOnClickMeButton(){
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(d -> driver.findElement(clickMeButton).isDisplayed());
        driver.findElement(clickMeButton).click();
    }

    public void closeModal(){
        driver.findElement(modalCloseButton).click();
    }

    public void clickIframeLink(){
        driver.findElement(iframeLink).click();
    }

    public void switchToIframe(){
        WebElement iframe = driver.findElement(mainIframe);
        driver.switchTo().frame(iframe);
    }

    public void sendMessage(String firstName, String lastName, String email, String comments){
        driver.findElement(contactUsOption).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(commentsField).sendKeys(comments);
        driver.findElement(submitButton).click();
    }

    public String getMessageSentText(){
        return driver.findElement(successMessage).getText();
    }

    public void clickDatePickerLink(){
        driver.findElement(datePickerLink).click();
    }

    public void clickOnDatePickerField(){
        driver.findElement(datePickerField).click();
    }

    public void selectDateDatePicker(Instant date){
        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d")
                .withZone(ZoneId.systemDefault());
        String dateDay = dayFormatter.format(date);

        driver.findElement(By.xpath("//div[@class='datepicker-days']//td[text()='"+dateDay+"']")).click();

    }
}

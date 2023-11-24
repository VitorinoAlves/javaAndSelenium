package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UltimateHome {
    private WebDriver driver;
    public UltimateHome(WebDriver driver){this.driver=driver;}

    By clickableIcon = By.xpath("//a[@href='/link-success/']/span/span");
    By linkSuccessPageTitle = By.xpath("//h1[@class='entry-title']");
    By nameField = By.xpath("//input[@id='et_pb_contact_name_0']");
    By emailField = By.xpath("//input[@id='et_pb_contact_email_0']");
    By emailMeButton = By.xpath("//button[@name='et_builder_submit_button']");
    By emailSentMessage = By.xpath("//div[@class='et-pb-contact-message']//p");

    public void clickClickableIcon(){
        driver.findElement(clickableIcon).click();
    }

    public String getLinkSuccessPageTitle(){
        return  driver.findElement(linkSuccessPageTitle).getText();
    }

    public void inputContactName(String name){
        driver.findElement(nameField).sendKeys(name);
    }
    public void inputContactEamil(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void clickOnEmailMeButton(){
        driver.findElement(emailMeButton).click();
    }
    public String getEmailSentMessage(){
        return driver.findElement(emailSentMessage).getText();
    }
}

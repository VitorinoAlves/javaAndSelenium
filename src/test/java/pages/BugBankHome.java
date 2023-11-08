package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BugBankHome {
    private WebDriver driver;

    public BugBankHome(WebDriver driver){this.driver=driver;}

    By userNameLabel = By.xpath("//p[@id='textName']");
    By extratoButton = By.xpath("//a[@id='btn-EXTRATO']");

    public String getUserNameLabel(){
        return driver.findElement(userNameLabel).getText();
    }

    public void clickExtratoButton(){
        driver.findElement(extratoButton).click();
    }
}

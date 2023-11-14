package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwagLabHome {
    private WebDriver driver;
    public SwagLabHome(WebDriver driver){this.driver=driver;}

    By productTitle = By.xpath("//span[@class='title']");

    public String getProductText(){
        return driver.findElement(productTitle).getText();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeBugerEats {
    private WebDriver driver;

    public HomeBugerEats(WebDriver driver){this.driver=driver;}

    private final By cadastrarButton = By.xpath("//a[@href='/deliver']");

    public void clickOnCadastrarButton(){
        driver.findElement(cadastrarButton).click();
    }

}

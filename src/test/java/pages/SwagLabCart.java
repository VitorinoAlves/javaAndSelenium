package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SwagLabCart {
    private WebDriver driver;
    public SwagLabCart(WebDriver driver){this.driver=driver;}

    By productName = By.xpath("//div[@class='inventory_item_name']");
    By productPrice = By.xpath("//div[@class='inventory_item_price']");
    By checkoutButton = By.xpath("//button[@id='checkout']");

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
    public List<String> getListOfProducts(){
        List<String> productNames = new ArrayList<String>();
        List<WebElement> productNameLists = driver.findElements(productName);
        for (WebElement nameList : productNameLists) {
            productNames.add(nameList.getText());
        }
        return productNames;
    }

    public List<String> getListPriceOfProducts(){
        List<String> productPrices = new ArrayList<String>();
        List<WebElement> productNameLists = driver.findElements(productPrice);
        for (WebElement nameList : productNameLists) {
            productPrices.add(nameList.getText());
        }
        return productPrices;
    }

}

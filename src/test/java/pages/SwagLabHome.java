package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class SwagLabHome {
    private WebDriver driver;
    public SwagLabHome(WebDriver driver){this.driver=driver;}

    By productTitle = By.xpath("//span[@class='title']");
    By productName = By.xpath("//div[@class='inventory_item_name ']");
    By sortSelector = By.xpath("//select[@data-test='product_sort_container']");
    By productPrice = By.xpath("//div[@class='inventory_item_price']");
    By addToCartButton = By.xpath("//div[@class='inventory_item']//button");
    By cartIcon = By.xpath("//a[@class='shopping_cart_link']");

    public String getProductText(){
        return driver.findElement(productTitle).getText();
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

    public void selectOptionSortSelector(String option){
        Select sortDropdown = new Select(driver.findElement(sortSelector));
        sortDropdown.selectByValue(option);
    }

    public void clickOnAddToCartByIndex(int index){
        List<WebElement> addToCartButtons = driver.findElements(addToCartButton);
        addToCartButtons.get(index).click();
    }

    public void clickOnCartIcon(){
        driver.findElement(cartIcon).click();
    }
}

package cases.exer03;

import graphql.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SwagLabLogin;
import utils.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortProductsSauceDemo extends Driver {

    @Test
    public void sortProducts(){
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        List<String> productNames = new ArrayList<String>();
        List<String> productNamesAfterSort = new ArrayList<String>();
        driver.get("https://www.saucedemo.com/");

        By productName = By.xpath("//div[@class='inventory_item_name ']");
        By sortSelector = By.xpath("//select[@data-test='product_sort_container']");
        swagLabLogin.login("standard_user","secret_sauce");

        List<WebElement> productNameLists = driver.findElements(productName);
        for (WebElement nameList : productNameLists) {
            productNames.add(nameList.getText());
        }
        Collections.reverse(productNames);

        Select sortDropdown = new Select(driver.findElement(sortSelector));
        sortDropdown.selectByValue("za");

        List<WebElement> productNameListsAfterSort = driver.findElements(productName);
        for (WebElement productNameList : productNameListsAfterSort) {
            productNamesAfterSort.add(productNameList.getText());
        }

        assertEquals(productNames, productNamesAfterSort);
    }
}

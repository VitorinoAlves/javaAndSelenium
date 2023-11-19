package cases.exer03;

import org.junit.jupiter.api.Test;
import pages.SwagLabCart;
import pages.SwagLabCheckout;
import pages.SwagLabHome;
import pages.SwagLabLogin;
import utils.Driver;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SortProductsSauceDemo extends Driver {

    /*Efetuar login com standard_user e mudar a forma de ordenação dos produtos*/
    @Test
    public void sortProducts(){
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);

        driver.get("https://www.saucedemo.com/");
        swagLabLogin.login("standard_user","secret_sauce");

        List<String> productNames = swagLabHome.getListOfProducts();
        Collections.reverse(productNames);

        swagLabHome.selectOptionSortSelector("za");

        List<String> productNamesAfterSort = swagLabHome.getListOfProducts();

        assertEquals(productNames, productNamesAfterSort);
    }

    /*realizar também a compra de um produto qualquer e validar*/
    @Test
    public void buyProduct(){
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);
        SwagLabCart swagLabCart = new SwagLabCart(driver);

        driver.get("https://www.saucedemo.com/");
        swagLabLogin.login("standard_user","secret_sauce");

        List<String> productNamesFromHome = swagLabHome.getListOfProducts();
        List<String> productPricesFromHome = swagLabHome.getListPriceOfProducts();
        swagLabHome.clickOnAddToCartByIndex(0);
        swagLabHome.clickOnCartIcon();

        List<String> productNamesFromCart = swagLabCart.getListOfProducts();
        List<String> productPricesFromCart = swagLabCart.getListPriceOfProducts();

        assertEquals(productNamesFromHome.get(0), productNamesFromCart.get(0));
        assertEquals(productPricesFromHome.get(0), productPricesFromCart.get(0));
    }

    /*Adicionar 3 itens a sacola e verificar a soma do valor total*/
    @Test
    public void buyThreeProducts(){
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);
        SwagLabCart swagLabCart = new SwagLabCart(driver);
        SwagLabCheckout swagLabCheckout = new SwagLabCheckout(driver);

        driver.get("https://www.saucedemo.com/");
        swagLabLogin.login("standard_user","secret_sauce");

        List<String> productNamesFromHome = swagLabHome.getListOfProducts();
        List<String> productPricesFromHome = swagLabHome.getListPriceOfProducts();
        swagLabHome.clickOnAddToCartByIndex(0);
        swagLabHome.clickOnAddToCartByIndex(1);
        swagLabHome.clickOnAddToCartByIndex(2);
        swagLabHome.clickOnCartIcon();

        swagLabCart.clickCheckoutButton();

        swagLabCheckout.inputFirstName("TestName");
        swagLabCheckout.inputLastName("LastName");
        swagLabCheckout.inputZipCode("85214");
        swagLabCheckout.clickContinueButton();
        String totalPrice = swagLabCheckout.getTotalPrice();

        System.out.println("");


    }
}

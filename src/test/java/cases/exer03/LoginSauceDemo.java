package cases.exer03;

import org.junit.jupiter.api.Test;
import pages.SwagLabHome;
import pages.SwagLabLogin;
import utils.Driver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSauceDemo extends Driver {
    /*Efetuar login com cada um dos tipos de usuário disponíveis*/
    @Test
    public void loginStandardUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);

        swagLabLogin.login("standard_user","secret_sauce");
        assertEquals("Products", swagLabHome.getProductText());

    }

    @Test
    public void lockedOutUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);

        swagLabLogin.login("locked_out_user","secret_sauce");
        assertEquals("Epic sadface: Sorry, this user has been locked out.", swagLabLogin.getAlertText());
    }

    @Test
    public void problemUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);

        swagLabLogin.login("problem_user","secret_sauce");
    }

    @Test
    public void performanceGlitchUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);

        swagLabLogin.login("performance_glitch_user","secret_sauce");
        assertEquals("Products", swagLabHome.getProductText());
    }

    @Test
    public void errorUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);

        swagLabLogin.login("error_user","secret_sauce");
        assertEquals("Products", swagLabHome.getProductText());
    }

    @Test
    public void visualUser(){
        driver.get("https://www.saucedemo.com/");
        SwagLabLogin swagLabLogin = new SwagLabLogin(driver);
        SwagLabHome swagLabHome = new SwagLabHome(driver);

        swagLabLogin.login("visual_user","secret_sauce");
        assertEquals("Products", swagLabHome.getProductText());
    }
}

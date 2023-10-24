package cases.admin;

import graphql.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginAdmin;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class Login {
    WebDriver driver;
    LoginAdmin loginAdmin;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        loginAdmin = new LoginAdmin(driver);

    }

    @AfterEach
    public void tearDown(){
        driver.close();
        driver.quit();
    }
    @Test
    public void loginIntoAdminPortal(){
        //WebDriver driver = new ChromeDriver();
        //driver.get("http://localhost:3000/");
        //LoginAdmin loginAdmin = new LoginAdmin(driver);

        /*WebElement usernameField = driver.findElement(By.xpath("//label[contains(text(),'Username')]/..//input"));
        WebElement passwordField = driver.findElement(By.xpath("//label[contains(text(),'Password')]/..//input"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys("sysadmin");
        passwordField.sendKeys("systemadmin");
        loginButton.click();*/

        loginAdmin.enterUsername("sysadmin");
        loginAdmin.enterPassword("systemadmin");
        loginAdmin.clockLogin();

        boolean logoutButtonIsVisible = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        assertTrue(logoutButtonIsVisible);

        //driver.close();
        //driver.quit();

    }

    @Test
    public void failedLoginAdminPortal(){
        //WebDriver driver = new ChromeDriver();
        //driver.get("http://localhost:3000/");
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));


        /*WebElement usernameField = driver.findElement(By.xpath("//label[contains(text(),'Username')]/..//input"));
        WebElement passwordField = driver.findElement(By.xpath("//label[contains(text(),'Password')]/..//input"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys("sysadmin");
        passwordField.sendKeys("testwrongpassword");
        loginButton.click();*/

        loginAdmin.enterUsername("sysadmin");
        loginAdmin.enterPassword("testwrongpassword");
        loginAdmin.clockLogin();

        wait.until(d -> driver.findElement(By.xpath("//div[@class='ant-modal-confirm-content']/div")).isDisplayed());
        WebElement errorModal = driver.findElement(By.xpath("//div[@class='ant-modal-confirm-content']/div"));
        String errorMessage = errorModal.getText();
        assertEquals("invalid password", errorMessage);

        //driver.close();
        //driver.quit();

    }
}

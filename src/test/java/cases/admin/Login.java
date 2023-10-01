package cases.admin;

import graphql.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    @Test
    public void loginIntoAdminPortal(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000/");

        WebElement usernameField = driver.findElement(By.xpath("//label[contains(text(),'Username')]/..//input"));
        WebElement passwordField = driver.findElement(By.xpath("//label[contains(text(),'Password')]/..//input"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys("sysadmin");
        passwordField.sendKeys("systemadmin");
        loginButton.click();

        boolean logoutButtonIsVisible = driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed();
        Assert.assertTrue(logoutButtonIsVisible);

        driver.close();
        driver.quit();

    }
}

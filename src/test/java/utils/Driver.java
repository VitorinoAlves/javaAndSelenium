package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class Driver {
    public static WebDriver driver;
    @BeforeEach
    public void setUp(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1366,1440");


        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown(){
        //close() is a webdriver command that closes the browser window currently in focus.
        //driver.close();

        for(String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            driver.close();
        }

        //quit() is a webdriver command which calls the driver.dispose method, which in turn closes all the browser windows and terminates the WebDriver session.
        //driver.quit();
    }

    @AfterAll
    public static void tearDownDriver(){
        driver.quit();
    }
}

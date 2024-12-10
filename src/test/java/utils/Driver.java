package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public class Driver {
    public static WebDriver driver;
    public static URL gridURL;

    @BeforeAll
    public static void startStandaloneGrid(){
        int port = PortProber.findFreePort();
        try{
            Main.main(
                    new String[]{
                            "standalone",
                            "--port",
                            String.valueOf(port),
                            "--selenium-manager",
                            "true",
                            "--enable-managed-downloads",
                            "true",
                            "--log-level",
                            "WARNING"
                    }
            );
            gridURL = new URI("http://192.168.1.3:" + port).toURL();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    public void setUp() throws MalformedURLException, URISyntaxException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1366,1440");
        //URL gridURL = new URL("http://192.168.1.3:6666");

        //driver = new ChromeDriver(options);
        driver = new RemoteWebDriver(gridURL, options);
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

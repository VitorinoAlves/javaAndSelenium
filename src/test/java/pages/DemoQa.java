package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQa {
    private WebDriver driver;
    public DemoQa(WebDriver driver){this.driver=driver;}

    By loginButton = By.xpath("//button[@id='login']");
    By usernameField = By.xpath("//input[@id='userName']");
    By passwordField = By.xpath("//input[@id='password']");
    By usernameHomeLabel = By.xpath("//label[@id='userName-value']");
    By addToYourCollectionButton = By.xpath("//button[text()='Add To Your Collection']");
    By profileMenuOption = By.xpath("//span[text()='Profile']/..");
    By deleteIcon = By.xpath("//span[@id='delete-record-undefined']");
    By confirmDeleteActionButton = By.xpath("//button[@id='closeSmallModal-ok']");

    public void performLoginAction(String username, String password){
        driver.findElement(loginButton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getUserNameHome(){
        return driver.findElement(usernameHomeLabel).getText();
    }

    public String getBookNameCollection(String bookTitle){
        return driver.findElement(By.xpath("//span[@id='see-book-"+bookTitle+"']/a")).getText();
    }

    public void clickProfileMenuOption(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(profileMenuOption));
    }

    public void addBookToColection(String bookTitle){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        driver.findElement(By.xpath("//a[text()='"+bookTitle+"']")).click();
        executor.executeScript("arguments[0].click();", driver.findElement(addToYourCollectionButton));
    }

    public void cleanAddedBooks(){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", driver.findElement(deleteIcon));
        executor.executeScript("arguments[0].click();", driver.findElement(confirmDeleteActionButton));
    }

    public String getAlertTextAndAccept(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        alert.accept();
        return alertMessage;
    }
}

package cases.exer6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoQa;
import utils.Driver;

import java.time.Duration;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoBookStore extends Driver {
    //https://www.baeldung.com/parameterized-tests-junit-5

    private static Stream<Arguments> provideCredentialsAndBooks() {
        return Stream.of(
                Arguments.of("bmartins", "Test123@", "Git Pocket Guide"),
                Arguments.of("framos", "Test123@", "Learning JavaScript Design Patterns"),
                Arguments.of("rsantos", "Test123@", "Designing Evolvable Web APIs with ASP.NET")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCredentialsAndBooks")
    public void addBookToList(String username, String password, String bookTitle){
        driver.get("https://demoqa.com/books");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor executor = (JavascriptExecutor)driver;

        DemoQa demoQa = new DemoQa(driver);

        By addToYourCollectionButton = By.xpath("//button[text()='Add To Your Collection']");
        By profileMenuOption = By.xpath("//span[text()='Profile']/..");
        By deleteIcon = By.xpath("//span[@id='delete-record-undefined']");
        By confirmDeleteActionButton = By.xpath("//button[@id='closeSmallModal-ok']");

        demoQa.performLoginAction(username, password);
        assertEquals(username, demoQa.getUserNameHome());

        driver.findElement(By.xpath("//a[text()='"+bookTitle+"']")).click();
        executor.executeScript("arguments[0].click();", driver.findElement(addToYourCollectionButton));

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMessage = driver.switchTo().alert().getText();
        assertEquals("Book added to your collection.", alertMessage);
        alert.accept();

        executor.executeScript("arguments[0].click();", driver.findElement(profileMenuOption));

        String listedBook = driver.findElement(By.xpath("//span[@id='see-book-"+bookTitle+"']/a")).getText();
        assertEquals(bookTitle, listedBook);
        executor.executeScript("arguments[0].click();", driver.findElement(deleteIcon));
        executor.executeScript("arguments[0].click();", driver.findElement(confirmDeleteActionButton));

    }
}

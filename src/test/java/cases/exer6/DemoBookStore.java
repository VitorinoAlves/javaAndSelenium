package cases.exer6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import utils.Driver;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DemoBookStore extends Driver {

    private static Stream<Arguments> provideCredentialsAndBooks() {
        return Stream.of(
                Arguments.of("bmartins", "Test123@"),
                Arguments.of("framos", "Test123@"),
                Arguments.of("rsantos", "Test123@")
        );
    }

    @ParameterizedTest
    @MethodSource("provideCredentialsAndBooks")
    public void addBookToList(String username, String password){
        driver.get("https://demoqa.com/books");

        By loginButton = By.xpath("//button[@id='login']");
        By usernameField = By.xpath("//input[@id='userName']");
        By passwordField = By.xpath("//input[@id='password']");
        By usernameHomeLabel = By.xpath("//label[@id='userName-value']");

        driver.findElement(loginButton).click();
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();

        String usernameNameFromHome = driver.findElement(usernameHomeLabel).getText();
        assertEquals(username, usernameNameFromHome);

    }
}

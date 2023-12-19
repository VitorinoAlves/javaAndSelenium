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
        DemoQa demoQa = new DemoQa(driver);

        demoQa.performLoginAction(username, password);
        assertEquals(username, demoQa.getUserNameHome());

        demoQa.addBookToColection(bookTitle);
        assertEquals("Book added to your collection.", demoQa.getAlertTextAndAccept());


        demoQa.clickProfileMenuOption();
        assertEquals(bookTitle, demoQa.getBookNameCollection(bookTitle));
        demoQa.cleanAddedBooks();

    }
}

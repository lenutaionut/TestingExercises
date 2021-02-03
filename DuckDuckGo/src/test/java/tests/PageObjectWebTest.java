package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.DuckDuckGoResultsPage;
import pageobjects.DuckDuckGoSearchPage;

import java.util.List;

import static java.lang.System.setProperty;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PageObjectWebTest {

    private WebDriver driver;

    @BeforeEach
    public void initWebDriver() {
        setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void searchDuckDuckGo() {
        DuckDuckGoSearchPage searchPage = new DuckDuckGoSearchPage(driver);
        searchPage.loadPage();
        searchPage.search("giant panda");

        DuckDuckGoResultsPage resultsPage = new DuckDuckGoResultsPage(driver);
        List<String> linkTexts = resultsPage.getResultsLinkText("panda");

        for (String text : linkTexts) {
            assertTrue(text.matches("(?i).*panda.*"));
        }
    }

    @AfterAll
    public void quitWebDriver() {
        driver.quit();
    }
}

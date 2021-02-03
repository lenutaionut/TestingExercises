package base;

import com.google.common.io.Files;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeAll
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
        driver = new ChromeDriver(getChromeOptions());
        goHome();
        setCookie();
    }

    @BeforeEach
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterAll
    public void quitWebDriver() {
        driver.quit();
    }

//    @AfterEach
    public void takeScreenshot() {
        var camera = (TakesScreenshot) driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        public Statement apply(Statement base, Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println("Hereeee: " + description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("resources/screenshots/testFail.png"));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
}

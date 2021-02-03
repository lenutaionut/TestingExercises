package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.System.setProperty;
import static org.apache.commons.lang3.SystemUtils.*;

public class BrowserGetter {

    public WebDriver getChromeDriver(){
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriverLinux");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.chrome.driver", "C:/Program Files/chromedriverMac");
        }

        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getFirefoxDriver() {
        if (!IS_OS_WINDOWS && !IS_OS_LINUX && !IS_OS_MAC) {
            throw new RuntimeException("Could not initialize browser due to unknown operating system!");
        }
        if (IS_OS_WINDOWS) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriver.exe");
        }
        if (IS_OS_LINUX) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriver");
        }
        if (IS_OS_MAC) {
            setProperty("webdriver.gecko.driver", "src/test/resources/browserBinaries/geckodriverMac");
        }

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public WebDriver getDriver() {
        switch (System.getProperty("browser").toLowerCase()) {
            case "chrome" :
                System.out.println("Chrome was chosen!");
                return getChromeDriver();
            case "firefox" :
                System.out.println("Firefox was chosen!");
                return getFirefoxDriver();
            default:
                throw new RuntimeException("Unsupported browser! Will not start any browser!");
        }
    }
}

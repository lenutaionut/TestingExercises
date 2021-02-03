package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends AbstractPage {

    private final static By inputField = By.id("target");
    private final static By resultText = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        super(driver);
    }

    public void enterText(String text) {
        getDriver().findElement(inputField).sendKeys(text);
    }

    /**
     * We get a pi (3.14) when pressing ALT and 227, numbers keyboard only!! (NUMPAD) at the same time
     * Then we introduce another string ("=3.14")
     */
    public void enterPi() {
        enterText(Keys.chord(Keys.ALT,  Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7) + "=3.14");
    }

    public String getResult() {
        return getDriver().findElement(resultText).getText();
    }

}

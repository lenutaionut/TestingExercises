package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends AbstractPage{

    private final static By clickHereLink = By.linkText("Click Here");

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickHere(){
        getDriver().findElement(clickHereLink).click();
    }
}

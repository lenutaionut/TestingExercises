package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends AbstractPage{

    private final static By example1Link = By.linkText("Example 1: Element on page that is hidden");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void clickExample1(){
        getDriver().findElement(example1Link).click();
    }
}

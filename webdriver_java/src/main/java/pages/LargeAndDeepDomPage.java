package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage extends AbstractPage{

    private final static By table = By.id("large-table");

    public LargeAndDeepDomPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToTable(){
        WebElement tableElement = getDriver().findElement(table);
        String script = "arguments[0].scrollIntoView()";
        ((JavascriptExecutor)getDriver()).executeScript(script, tableElement);
    }


}

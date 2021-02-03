package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage extends AbstractPage {

    private final static By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Scroll until paragraph with index specified is in view
     * @param index 1-based
     */
    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        var jsExecutor = (JavascriptExecutor) getDriver();

        while (getNumberOfParagraphsPresent() < index) {
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent() {
        return getDriver().findElements(textBlocks).size();
    }
}

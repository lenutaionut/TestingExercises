package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage extends AbstractPage {


    private String editorIdFrame = "mce_0_ifr";
    private final static By textArea = By.id("tinymce");
    private final static By increaseIndentButton = By.cssSelector("button[title='Increase indent']");

    public WysiwygEditorPage(WebDriver driver) {
        super(driver);
    }

    public void clearTextArea() {
        switchToEditArea();
        getDriver().findElement(textArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        getDriver().findElement(textArea).sendKeys(text);
        switchToMainArea();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        String text = getDriver().findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    public void increaseIndention(){
        getDriver().findElement(increaseIndentButton).click();
    }

    /**
     * inside iframe there is a html document, so we have to access it in this way
     */
    private void switchToEditArea() {
        getDriver().switchTo().frame(editorIdFrame);
    }

    private void switchToMainArea(){
        getDriver().switchTo().parentFrame();
    }
}

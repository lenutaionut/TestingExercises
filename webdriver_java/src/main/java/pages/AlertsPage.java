package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends AbstractPage {

    private final static By triggerAlertButton = By.xpath(".//button[text() ='Click for JS Alert']");
    private static final By triggerConfirmButton = By.xpath(".//button[. ='Click for JS Confirm']");
    private final static By triggerPromptButton = By.xpath(".//button[. = 'Click for JS Prompt']");
    private final static By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void triggerAlert() {
        getDriver().findElement(triggerAlertButton).click();
    }

    public void triggerConfirm() {
        getDriver().findElement(triggerConfirmButton).click();
    }

    public void triggerPrompt() {
        getDriver().findElement(triggerPromptButton).click();
    }

    public void alert_clickToAccept() {
        getDriver().switchTo().alert().accept();
    }

    public void alert_clickToDismiss() {
        getDriver().switchTo().alert().dismiss();
    }

    public void alert_setInput(String text) {
        getDriver().switchTo().alert().sendKeys(text);
    }

    public String alert_getText() {
        return getDriver().switchTo().alert().getText();
    }

    public String getResult() {
        return getDriver().findElement(results).getText();
    }
}

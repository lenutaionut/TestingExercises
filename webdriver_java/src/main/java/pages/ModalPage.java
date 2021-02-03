package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ModalPage extends AbstractPage {

    private final static By modalTitle = By.cssSelector("div.modal-title>h3");

    public ModalPage(WebDriver driver) {
        super(driver);
    }

    public String getModalTitle() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        return getDriver().findElement(modalTitle).getText();
    }
}

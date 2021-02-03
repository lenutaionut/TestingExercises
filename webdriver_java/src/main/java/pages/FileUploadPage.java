package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends AbstractPage {

    private final static By fileUploadInput = By.id("file-upload");
    private final static By fileUploadButton = By.id("file-submit");
    private final static By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void clickUploadButton() {
        getDriver().findElement(fileUploadButton).click();
    }

    /**
     * Provides path of file to the form then clicks Upload button
     * @param absolutePathOfFile The complete path of the file to upload
     */
    public void uploadFile(String absolutePathOfFile) {
        getDriver().findElement(fileUploadInput).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }

    public String getUploadedFiles(){
        return getDriver().findElement(uploadedFiles).getText();
    }
}

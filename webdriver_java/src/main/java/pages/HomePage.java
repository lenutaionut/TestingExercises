package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {

    private final static By resultsLinks = By.cssSelector("li a");
    private final static By dropDownLink = By.linkText("Dropdown");
    private final static By hoverLink = By.linkText("Hovers");
    private final static By keyPresses = By.linkText("Key Presses");
    private final static By alerts = By.linkText("JavaScript Alerts");
    private final static By fileUpload = By.linkText("File Upload");
    private final static By entryAd = By.linkText("Entry Ad");
    private final static By wysiwygEditor = By.linkText("WYSIWYG Editor");
    private final static By largeDeepDOM = By.linkText("Large & Deep DOM");
    private final static By infiniteScroll = By.linkText("Infinite Scroll");
    private final static By dynamicLoading = By.linkText("Dynamic Loading");
    private final static By multipleWindows = By.linkText("Multiple Windows");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public DropdownPage clickDropDown() {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(resultsLinks));
        clickLink(dropDownLink);
        return new DropdownPage(getDriver());
    }

    public HoversPage clickHover() {
        clickLink(hoverLink);
        return new HoversPage(getDriver());
    }

    public KeyPressesPage clickKeyPresses() {
        clickLink(keyPresses);
        return new KeyPressesPage(getDriver());
    }

    public AlertsPage clickJavaScriptAlerts() {
        clickLink(alerts);
        return new AlertsPage(getDriver());
    }

    public FileUploadPage clickFileUpload() {
        clickLink(fileUpload);
        return new FileUploadPage(getDriver());
    }

    public ModalPage clickEntryAd() {
        clickLink(entryAd);
        return new ModalPage(getDriver());
    }

    public WysiwygEditorPage clickWysiwygEditor() {
        clickLink(wysiwygEditor);
        return new WysiwygEditorPage(getDriver());
    }

    public LargeAndDeepDomPage clickLargeAndDeepDom() {
        clickLink(largeDeepDOM);
        return new LargeAndDeepDomPage(getDriver());
    }

    public InfiniteScrollPage clickInfiniteScroll() {
        clickLink(infiniteScroll);
        return new InfiniteScrollPage(getDriver());
    }

    public DynamicLoadingPage clickDynamicLoading() {
        clickLink(dynamicLoading);
        return new DynamicLoadingPage(getDriver());
    }

    public MultipleWindowsPage clickMultipleWindow(){
        clickLink(multipleWindows);
        return new MultipleWindowsPage(getDriver());
    }

    public void clickLink(By linkText) {
        getDriver().findElement(linkText).click();
    }
}

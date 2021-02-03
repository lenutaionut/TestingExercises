package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends AbstractPage {

    private final static By figureBox = By.className("figure");
    private final static By boxCaption = By.className("figcaption");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    /**
     * When hover the figure, a div is showing up (caption) => we get more than an element
     *
     * @param index starts at 1
     * @return FigureCaption
     */
    public FigureCaption hoverOverFigure(int index) {
        //list index starts at 0, but param index is set to start at 1
        WebElement figure = getDriver().findElements(figureBox).get(index - 1);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public class FigureCaption {

        private WebElement caption;
        private final By header = By.tagName("h5");
        private final By link = By.tagName("a");

        public FigureCaption(WebElement caption) {
            this.caption = caption;
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getTitle() {
            return caption.findElement(header).getText();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }
    }
}

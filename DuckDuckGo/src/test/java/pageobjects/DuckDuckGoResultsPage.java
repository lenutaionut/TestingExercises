package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.LinkedList;
import java.util.List;

public class DuckDuckGoResultsPage extends AbstractPage {

    public final static By resultsLink = By.cssSelector("div.results_links_deep a.result__a");


    public DuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultsLinkText(String phrase) {
        getWait().until(ExpectedConditions.titleContains(phrase));
        getWait().until(ExpectedConditions.visibilityOfElementLocated(resultsLink));

        List<WebElement> resultLinks = getDriver().findElements(resultsLink);
        List<String> linkTexts = new LinkedList<>();

        for (WebElement e : resultLinks) {
            linkTexts.add(e.getText());
        }

        return linkTexts;
    }

}

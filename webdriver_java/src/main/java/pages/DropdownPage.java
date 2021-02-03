package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends AbstractPage {

    private final static By dropDown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectFromDropDown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
       List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
       return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(getDriver().findElement(dropDown));
    }

}

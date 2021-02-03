package dropdown;

import org.junit.jupiter.api.Test;
import base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropDownTest extends BaseTest {

    @Test
    public void testSelectOption() {
        var dropDownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        var selectedOptions = dropDownPage.getSelectedOptions();
        assertEquals(1, selectedOptions.size(), "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");
    }
}

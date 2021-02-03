package keys;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeysTest extends BaseTest {

    @Test
    public void testBackspace(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals("You entered: BACK_SPACE", keyPage.getResult());
    }

    @Test
    public void testPi(){
        var keyPage = homePage.clickKeyPresses();
        keyPage.enterPi();
    }
}

package alerts;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalPageTest extends BaseTest {

    @Test
    public void testTitle() {
        var modalPage = homePage.clickEntryAd();
        String title = modalPage.getModalTitle();
        assertEquals("THIS IS A MODAL WINDOW", title, "Modal title incorrect");
    }
}

package hover;

import org.junit.jupiter.api.Test;
import base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverUser1() {
        var hoversPage = homePage.clickHover();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals("name: user1", caption.getTitle(), "Caption title incorrect!");
        assertEquals("View profile", caption.getLinkText(), "Caption link text incorrect!");
        assertTrue(caption.getLink().contains("/users/1"), "Caption link incorrect!");

    }
}

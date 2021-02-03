package javascript;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class JavaScriptTest extends BaseTest {

    @Test
    public void testScrollTable(){
        homePage.clickLargeAndDeepDom().scrollToTable();

    }

    @Test
    public void testScrollToFifthParagraph(){
        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }
}

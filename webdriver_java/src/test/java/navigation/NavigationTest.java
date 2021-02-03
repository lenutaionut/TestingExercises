package navigation;

import base.BaseTest;
import org.junit.jupiter.api.Test;

public class NavigationTest extends BaseTest {
    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindow().clickHere();
        getWindowManager().switchToTab("New Window");
    }
}

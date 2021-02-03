package alerts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest extends BaseTest {

    @Test
    public void testAcceptAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        Assertions.assertEquals("You successfuly clicked an alert", alertsPage.getResult(), "Result text incorrect");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text =alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals("I am a JS Confirm", text, "Alert text incorrect");
    }

    @Test
    public void testSendKeys(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();

        alertsPage.alert_setInput("TAU result");
        alertsPage.alert_clickToAccept();
        Assertions.assertEquals("You entered: TAU result", alertsPage.getResult(), "Incorrect result");
    }
}

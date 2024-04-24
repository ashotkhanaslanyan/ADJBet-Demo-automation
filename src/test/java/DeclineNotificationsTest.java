import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainPage.DeclineNotificationsAlert;

@TestInstance(Lifecycle.PER_CLASS)
public class DeclineNotificationsTest {

    private DeclineNotificationsAlert objDeclineNotificationsAlert;
    
    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // Now driver is an instance variable
        driver.get("https://www.adjarabet.am/en");
        objDeclineNotificationsAlert = new DeclineNotificationsAlert(driver);
    }

    @Test
    public void onAlertClickOnDecline() {
        objDeclineNotificationsAlert.WaitForNotificationsAlert();
        objDeclineNotificationsAlert.ClickDeclineNotifications();    
    }
}

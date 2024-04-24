import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainPage.NotificationsAlert;
import pages.MainPage.LogIn;

@TestInstance(Lifecycle.PER_CLASS)
public class DeclineNotificationsTest {

    private WebDriver driver;
    private NotificationsAlert objNotificationsAlert;
    private LogIn objLogIn;
    
    @BeforeAll
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.adjarabet.am/en");
        objNotificationsAlert = new NotificationsAlert(driver);
        objLogIn = new LogIn(driver);
    }

    @Test
    public void on_alert_click_on_decline() {
        objNotificationsAlert.WaitForNotificationsAlert();
        objNotificationsAlert.ClickDeclineNotifications();
    }

    @Test
    public void test_log_in_with_credentials() {
        objLogIn.LogInWithCredentials();
    }

    // @AfterAll
    // public void teardown() {
    //     if(driver != null) {
    //         driver.quit();
    //     }
    // }
}

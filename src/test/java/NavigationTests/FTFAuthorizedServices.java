package NavigationTests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainPage.AdjBetNotifications;
import pages.MainPage.LogIn;
import pages.MainPage.NotificationsAlert;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FTFAuthorizedServices {

    private WebDriver driver;
    private NotificationsAlert objNotificationsAlert;
    private LogIn objLogIn;
    private AdjBetNotifications objAdjBetNotifications;

    @BeforeAll
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.adjarabet.am/en");
        objNotificationsAlert = new NotificationsAlert(driver);
        objLogIn = new LogIn(driver);
        objAdjBetNotifications = new AdjBetNotifications(driver);

        // Close the initial Alert that appears when opening the page
        objNotificationsAlert.CloseNotificationsAlert();

        // Log in to the system
        objLogIn.LogInWithCredentials();
    }

    @BeforeEach
    public void close_important_notice_notification() {
        objAdjBetNotifications.CloseImportantNotice();
    }

    @Test
    public void check_sports_page_is_unavailable() {
        
    }

    @Test
    public void check_betfair_exchange_page_is_unavailable() {
        
    }

    @Test
    public void check_virtual_sports_page_is_unavailable() {
        
    }

    // @AfterAll
    // public void teardown() {
    //     if(driver != null) {
    //         driver.quit();
    //     }
    // }
}

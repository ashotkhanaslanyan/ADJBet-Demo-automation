package NavigationTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.MainPage.AdjBetNotifications;
import pages.MainPage.LogIn;
import pages.MainPage.NotificationsAlert;
import pages.MainPage.Navigation;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FTFAuthorizedServicesTest {

    private WebDriver driver;
    private NotificationsAlert objNotificationsAlert;
    private LogIn objLogIn;
    private AdjBetNotifications objAdjBetNotifications;
    private Navigation objNavigation;
    private pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();


    @BeforeAll
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.adjarabet.am/en");
        objNotificationsAlert = new NotificationsAlert(driver);
        objLogIn = new LogIn(driver);
        objAdjBetNotifications = new AdjBetNotifications(driver);
        objNavigation = new Navigation(driver);

        // Close the initial Alert that appears when opening the page
        objNotificationsAlert.CloseNotificationsAlert();

        // Log in to the system
        objLogIn.LogInWithCredentials();

        // Close Important Notice Notification
        objAdjBetNotifications.CloseImportantNotice();
    }

    @AfterEach
    public void close_important_notice_notification() {
        objAdjBetNotifications.CloseImportantNotice();
    }

    @Test
    public void check_sports_page_is_unavailable() {
        objNavigation.OpenSportsPage();
        objAdjBetNotifications.CloseImportantNotice();
        objAdjBetNotifications.WaitForFTFMessage();
        assertEquals(repo.FTFExpectedMessage, driver.findElement(repo.FTFMessageContainer).getText());
        objAdjBetNotifications.CloseFTFNotification();
    }

    @Test
    public void check_betfair_exchange_page_is_unavailable() {
        objNavigation.OpenBetfairExchangePage();
        objAdjBetNotifications.CloseImportantNotice();
        objAdjBetNotifications.WaitForFTFMessage();
        assertEquals(repo.FTFExpectedMessage, driver.findElement(repo.FTFMessageContainer).getText());
        objAdjBetNotifications.CloseFTFNotification();
    }

    @Test
    public void check_virtual_sports_page_is_unavailable() {
        objNavigation.OpenVirtualSportsPage();
        objAdjBetNotifications.CloseImportantNotice();
        objAdjBetNotifications.WaitForFTFMessage();
        assertEquals(repo.FTFExpectedMessage, driver.findElement(repo.FTFMessageContainer).getText());
        objAdjBetNotifications.CloseFTFNotification();
    }

    @AfterAll
    public void teardown() {
        if(driver != null) {
            driver.quit();
        }
    }
}

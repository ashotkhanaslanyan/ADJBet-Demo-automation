package pages.MainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DeclineNotificationsAlert {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();

    public DeclineNotificationsAlert(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void WaitForNotificationsAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.NotificationsAlertField));
    }

    public void ClickDeclineNotifications() {
        driver.findElement(repo.DeclineNotificationsBtn).click();
    }
}

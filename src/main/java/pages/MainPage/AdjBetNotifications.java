package pages.MainPage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdjBetNotifications {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();

    public AdjBetNotifications(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void CloseImportantNotice() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.ImportantNotif));
        driver.findElement(repo.CloseNotifCross).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(repo.ImportantNotif, 0));
    }

    public void CloseFTFNotification() {
        driver.findElement(repo.CloseNotifCross).click();
        wait.until(ExpectedConditions.numberOfElementsToBe(repo.FTFMessageContainer, 0));
    }

    public void WaitForFTFMessage() {
        wait.until(ExpectedConditions.elementToBeClickable(repo.FTFMessageContainer));
    }
}

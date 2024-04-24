package pages.MainPage;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import pages.MainPage.Tools.DecryptCredentials;

public class LogIn {

    private final WebDriver driver;
    private final pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public void LogInWithCredentials() {
//        driver.findElement(repo.UserNameField).sendKeys(UserName);
//        driver.findElement(repo.PasswordField).sendKeys(PassWord);
    }
}

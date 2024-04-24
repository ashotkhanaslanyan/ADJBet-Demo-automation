package pages.MainPage;

import org.openqa.selenium.WebDriver;
import pages.MainPage.Tools.DecryptCredentials;

public class LogIn {

    private final WebDriver driver;
    private final pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    public void LogInWithCredentials() throws Exception {
        DecryptCredentials.Decrypt();
        driver.findElement(repo.UserNameField).sendKeys(DecryptCredentials.UserName);
        driver.findElement(repo.PasswordField).sendKeys(DecryptCredentials.PassWord);
        driver.findElement(repo.LoginBtn).click();
    }
}

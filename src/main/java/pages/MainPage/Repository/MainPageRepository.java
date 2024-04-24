package pages.MainPage.Repository;

import org.openqa.selenium.By;

public class MainPageRepository {

    // Notifications alert repo items
    public By DeclineNotificationsBtn = By.id("webpush-custom-prompt-button1");
    public By NotificationsAlertField = By.id("webpush-custom-prompt");

    // Log-in form repo items
    public By UserNameField = By.xpath(".//input[@data-id='username']");
    public By PasswordField = By.xpath(".//input[@data-id='password']");
}


package pages.MainPage.Repository;

import org.openqa.selenium.By;

public class MainPageRepository {

    // Notifications alert repo items
    public By DeclineNotificationsBtn = By.id("webpush-custom-prompt-button1");
    public By NotificationsAlertField = By.id("webpush-custom-prompt");

    // Log-in form repo items
    public By UserNameField = By.xpath(".//input[@data-id='username']");
    public By PasswordField = By.xpath(".//input[@data-id='password']");
    public By LoginBtn = By.xpath(".//button[@data-id='login-btn']");

    // Important Notice notification repo items
    public By ImportantNotif = By.xpath(".//div[contains(text(), 'Important notice')]");
    public By CloseNotifCross = By.xpath(".//a[@data-test-id='popup-close']");
}


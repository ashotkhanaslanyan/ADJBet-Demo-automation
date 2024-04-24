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

    // Navigation items
    public By SportsPage = By.xpath(".//a[@data-test-id='navigation-SPORTS']");
    public By BetfairExchangePage = By.xpath(".//a[@data-test-id='navigation-BETFAIR EXCHANGE']");
    public By VirtualSportsPage = By.xpath(".//a[@data-test-id='navigation-VIRTUAL SPORT']");

    // AdjBet FTF Authorization notification repo items
    public String FTFExpectedMessage = "In order to be able to use the sports products please pass face-to-face verification and have your identification document checked in our offices.";
    public By FTFMessageContainer = By.xpath(".//adj-inner-html/div");
}


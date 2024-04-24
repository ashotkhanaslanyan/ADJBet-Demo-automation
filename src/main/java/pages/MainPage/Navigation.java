package pages.MainPage;

import org.openqa.selenium.WebDriver;

public class Navigation {

    private final WebDriver driver;
    private final pages.MainPage.Repository.MainPageRepository repo = new pages.MainPage.Repository.MainPageRepository();

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public void OpenSportsPage() {
        driver.findElement(repo.SportsPage).click();
    }

    public void OpenBetfairExchangePage() {
        driver.findElement(repo.BetfairExchangePage).click();
    }

    public void OpenVirtualSportsPage() {
        driver.findElement(repo.VirtualSportsPage).click();
    }
}

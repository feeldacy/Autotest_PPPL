package test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    public By logoutButton = By.id("logout");
    public By loginPageTitle = By.id("login-title");
    public By successMessage = By.cssSelector(".alert-success");
    public By sessionError = By.cssSelector(".session-expired");


    public void clickBtn(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }
}
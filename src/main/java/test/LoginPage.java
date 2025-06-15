package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    public By emailLocator = By.id("email");
    public By passwordLocator = By.id("password");
    public By loginButtonLocator = By.xpath("//button[contains(text(),'Masuk') or @type='submit']");
    public By errorMessageLocator = By.xpath("//div[contains(@class,'alert') or contains(@class,'error')]");
    public By dashboardHeaderLocator = By.xpath("//h1[contains(text(),'Dashboard') or contains(text(),'Welcome')]");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void kirimData(By field, String query) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        element.sendKeys(query);
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator));
        loginBtn.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }



}
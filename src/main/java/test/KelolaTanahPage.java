package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KelolaTanahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public KelolaTanahPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public By detailBtn = By.xpath("//*[@id=\"groundTable\"]/tbody/tr[1]/td[5]/div/button[2]");
    public By modalDetailTitle = By.xpath("//*[@id=\"detailModal\"]/div/h2");

    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getText(By element){
        return  driver.findElement(element).getText();
    }
}

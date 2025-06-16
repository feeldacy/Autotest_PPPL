package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.WebSocketFrame;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestoreTanahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RestoreTanahPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public By tombolRestore = By.xpath("//*[@id=\"deletedGroundTable\"]/tbody/tr[1]/td[5]/div/button[1]");
    public By tombolPulihkan = By.xpath("//*[@id=\"restoreModal\"]/div/div[3]/div[2]/button[2]");
    public By titleModal = By.xpath("//*[@id=\"restoreModal\"]/div/div[2]/h2");
    public By tombolKembali = By.id("backBtn");
    public By toastMessageSuccess = By.xpath("//div[contains(@class, 'toastify') and contains(text(), 'Data berhasil, dipulihkan')]");


    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public String getCurrentUrl() {
        wait.until(ExpectedConditions.urlContains("restore"));
        return driver.getCurrentUrl();
    }

    public String getText(By element){
        return  driver.findElement(element).getText();
    }
}

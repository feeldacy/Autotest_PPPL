package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditTanahPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EditTanahPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public By fieldNamaTanah = By.id("nama_tanah");
    public By fieldLuasTanah = By.id("luas_tanah");
    public By tombolPerbarui = By.id("perbarui");

    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }

    public void kirimData(By field, String query) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(field));
        element.sendKeys(query);
    }

    //    GETTER
    public String getCurrentUrl() {
        wait.until(ExpectedConditions.urlContains("admin"));
        return driver.getCurrentUrl();
    }
}

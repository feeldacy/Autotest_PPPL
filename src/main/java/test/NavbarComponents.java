package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavbarComponents {

    private WebDriver driver;
    private WebDriverWait wait;

    public NavbarComponents(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    //Loactor
    public By kelolaTanahMenu = By.id("manageGround");
    public By kelolaAdminMenu = By.id("manageAdmin");
    public By profilAvatar = By.cssSelector("div.profile-avatar");
    public By kelolaTanah = By.id("manageGround");

    public void clickButton(By locator) {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        button.click();
    }
}

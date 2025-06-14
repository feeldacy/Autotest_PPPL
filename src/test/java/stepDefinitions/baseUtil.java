package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class baseUtil {

    public static WebDriver driver;

    protected void loginStep(){
        driver.get("https://digitalmap-umbulharjo.madanateknologi.web.id/login");
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testingSuperA@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("jajaSAdmin");
        driver.findElement(By.xpath("//button[contains(text(),'Masuk') or @type='submit']")).click();
    }
}

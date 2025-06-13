package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class baseStep {

    @Before
    public void setup() {
        if (baseUtil.driver == null) {
            baseUtil.driver = new ChromeDriver();
            baseUtil.driver.manage().window().maximize();
        }
    }

    @After
    public void teardown() {
        if (baseUtil.driver != null) {
            baseUtil.driver.quit();
            baseUtil.driver = null;
        }
    }
}

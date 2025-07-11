package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ScreenShotUtil {

    public static String takeScreenShot(WebDriver driver, String name) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String  destination = System.getProperty("user.dir") + "/screenshots/" + name + ".png";

        try {
            Files.createDirectories(Paths.get(
                    System.getProperty("user.dir") + "/screenshots/"
            ));
            Files.copy(source.toPath(), Paths.get(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }
}

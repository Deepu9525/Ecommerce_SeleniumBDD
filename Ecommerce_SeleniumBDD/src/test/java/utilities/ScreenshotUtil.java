package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtil {
    public static byte[] captureScreenshot(WebDriver driver, String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            //Save to file (optional but useful)
            String path = "reports/screenshots/" + fileName + ".png";
            Files.write(Paths.get(path), screenshot);
            return screenshot;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

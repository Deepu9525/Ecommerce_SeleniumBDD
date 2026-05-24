package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser){
        System.out.println("Launching browser: " + browser);
       if(browser == null){
           browser = "chrome"; //default
       }

       switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                // Disable notifications & ads
                prefs.put("profile.default_content_setting_values.notifications", 2);
                prefs.put("profile.managed_default_content_settings.ads", 2);

                options.setExperimentalOption("prefs", prefs);
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("start-maximized");

                driver.set(new ChromeDriver(options));

                break;

            case "firefox":
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                driver.set(new EdgeDriver());
                break;

            default:
                throw new IllegalArgumentException(("Browser not supported: ") + browser);
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if (getDriver() != null){
            getDriver().quit();
            driver.remove();
        }

    }

}







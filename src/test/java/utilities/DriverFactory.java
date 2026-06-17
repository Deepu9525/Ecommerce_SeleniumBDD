package utilities;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    Logger log = LoggerUtil.getLogger(DriverFactory.class);

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

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);

                // Disable Address Save popup
                prefs.put("autofill.profile_enabled", false);


                System.out.println("Disabling Password Save Popup");
                System.out.println("Disabling Address Save Popup");
                System.out.println("Disabling Credit Card Save Popup");

                options.setExperimentalOption("prefs", prefs);

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







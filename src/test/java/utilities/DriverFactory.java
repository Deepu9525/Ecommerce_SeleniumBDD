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
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final Logger log = LoggerUtil.getLogger(DriverFactory.class);

    public static void initDriver(String browser){
        log.info("Launching browser: " + browser);
       if(browser == null){
           browser = "chrome"; //default
           log.info("Starting browser: " + browser, Thread.currentThread().getName());
       }

       switch (browser.toLowerCase()){
            case "chrome":
                log.info("Initializing Chrome browser");
                ChromeOptions options = new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                // Disable notifications & ads

                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);

                // Disable Address Save popup
                prefs.put("autofill.profile_enabled", false);

                log.info("Disabling Password Save Popup");
                log.info("Disabling Address Save Popup");
                log.info("Disabling Credit Card Save Popup");

                options.setExperimentalOption("prefs", prefs);

                driver.set(new ChromeDriver(options));

                break;

            case "firefox":
                log.info("Initializing Firefox browser");
                driver.set(new FirefoxDriver());
                break;

            case "edge":
                log.info("Initializing edge browser");
                driver.set(new EdgeDriver());
                break;

            default:
                log.error("Unsupported browser: {}", browser);
                throw new IllegalArgumentException(("Browser not supported: ") + browser);
        }

        getDriver().manage().window().maximize();
        log.info("Browser started successfully | Thread: {}",
                Thread.currentThread().getName());
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        if (getDriver() != null){
            log.info("Closing browser | Thread: {}",
                    Thread.currentThread().getName());
            getDriver().quit();
            driver.remove();
            log.info("Browser closed successfully");
        }
    }
}







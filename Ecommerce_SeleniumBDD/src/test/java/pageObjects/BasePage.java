package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected Logger log = LoggerUtil.getLogger(this.getClass());

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeout()));
    }

    //Wait for visibility
    public WebElement waitForVisibility(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Click
    public void click(By locator){
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }catch (Exception e){
            log.warn("Click failed for locator: " + locator + " - Falling back to JS click");
            WebElement element = waitForVisibility(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    //Send keys
    public void type(By locator, String text){
        //getElement(locator).sendKeys(text);
        WebElement element = waitForVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }


    //Get text
    public String getText(By locator){
        //return getElement(locator).getText();
        return waitForVisibility(locator).getText();
    }

    //Check visible
    public boolean isDisplayed(By locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }catch(Exception e){
            log.error("Element not visible: " + locator);
            return false;
        }
    }

}


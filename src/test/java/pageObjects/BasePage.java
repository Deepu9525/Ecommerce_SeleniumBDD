package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;
import utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import java.util.List;

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

    //Get multiple elements
    public List<WebElement> getElements(By locator){
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
//        return wait.until(
//                ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //Get single element
    public WebElement getElement(By locator){
        return waitForVisibility(locator);
    }

    public List<WebElement> getOptionalElements(By locator){
        return driver.findElements(locator);
    }

    public String getCurrentUrl(){
        log.info("Getting current URL");
        return driver.getCurrentUrl();
    }

    public void handleIframePopup() {

        List<WebElement> iframes =
                driver.findElements(By.tagName("iframe"));

        log.info("Total Frames = " + iframes.size());

        for (WebElement frame : iframes) {

            try {

                driver.switchTo().defaultContent();
                driver.switchTo().frame(frame);

                List<WebElement> closeBtns =
                        driver.findElements(
                                By.id("dismiss-button-element"));

                log.info("dismiss-button-element count = " + closeBtns.size());

                if (!closeBtns.isEmpty()) {

                    log.info("Close button found");

                    ((JavascriptExecutor) driver)
                            .executeScript(
                                    "arguments[0].click();",
                                   closeBtns.get(0));

                    log.info("Popup Closed");

                    return;
                }

            } catch (Exception e) {

                log.info("Frame skipped");

            } finally {

                driver.switchTo().defaultContent();
            }
        }

        log.info("Popup not found in any frame");
    }

    public void handleGoogleVignette() {

        try {

            log.info("Current URL before checking vignette: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains("google_vignette")) {

                log.info("Google Vignette Detected");

                driver.navigate().back();

                wait.until(driver ->
                        !driver.getCurrentUrl().contains("google_vignette"));

                log.info("Current URL : " + driver.getCurrentUrl());

            }else{

                log.info("No Google Vignette Found");
            }

        } catch (Exception e) {

            log.error("Error while handling Google Vignette", e);
        }
    }
}



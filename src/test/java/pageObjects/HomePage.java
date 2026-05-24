package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    //Logger log = LoggerUtil.getLogger(HomePage.class);

    //Constructor
    public HomePage(WebDriver driver){
        super(driver);

    }

    //Locators
    By logoImg = By.xpath("//div[@class='logo pull-left']//img");
    //CSS locators div.logo.pull-left img


    By signuplogin = By.xpath("//a[@href='/login']");
    //CSs Selectors: [href='/login']

    By logout = By.cssSelector("[href='/logout']");

    By scrollDown = By.cssSelector("[class='single-widget'] h2");

    By subscriptionEmail = By.cssSelector("[id='susbscribe_email']");

    By subscriptionSubmit = By.cssSelector("[id='subscribe']");

    By subscriptionSuccessMessage = By.xpath("//div[@class='alert-success alert']");

    By cartButton = By.cssSelector("[href='/view_cart']");


    //Actions
    public boolean isLogoVisible(){
        //return driver.findElement(logoImg).isDisplayed();
        log.info("Verifying logo visible");
        return isDisplayed(logoImg);
    }

    public void clickSignupLogin(){
        //driver.findElement(signuplogin).click();
        log.info("Clicking on Signup");
        click(signuplogin);
    }

    public boolean isSignupLoginVisible(){
        return isDisplayed(signuplogin);

    }

    public void clickLogout(){
        log.info("Clicking on logout......");
        click(logout);
    }

    public void scrollToFooter(){
        log.info("Scroll down to footer to subscription");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement footer = getElement(scrollDown);
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
        log.info(js.executeScript("return window.pageYOffset;"));

    }

    public String getSubscriptionText(){
        log.info("Verifying Subscription text visible with scroll down");
        return getText(scrollDown);
    }

    public void enterSubscriptionEmail(String email){
        log.info("Enter subscription email");
        type(subscriptionEmail,email);

    }

    public void clickSubscriptionSubmit(){
        click(subscriptionSubmit);
    }

    public boolean isSubscribeSuccessMessageVisible(){
        log.info("Verifying Subscription success message visible");
        return isDisplayed(subscriptionSuccessMessage);
    }

    public void clickCartButton(){
        log.info("Clicking on cart button");
        click(cartButton);
    }

}


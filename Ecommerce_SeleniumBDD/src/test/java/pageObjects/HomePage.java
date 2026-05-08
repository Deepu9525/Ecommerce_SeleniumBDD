package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}


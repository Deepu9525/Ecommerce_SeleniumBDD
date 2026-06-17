package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By proceedToCheckout = By.cssSelector("[class='btn btn-default check_out']");

    By registerLogin = By.xpath("//a[@href='/login']/u");

    //Actions
    public boolean isCartPageDisplayed(){
        log.info("Proceed to Checkout button is displayed");
        boolean urlCheck = getCurrentUrl().contains("view_cart");
        log.info("Current URL: " + urlCheck);
        log.info("Current URL: " + getCurrentUrl());
        boolean proceedToCheckoutStatus = isDisplayed(proceedToCheckout);
        return urlCheck && proceedToCheckoutStatus;
    }

    public void clickProceedToCheckout(){
        log.info("Clicking on Proceed to Checkout button");
        click(proceedToCheckout);
    }

    public void clickRegisterLoginButton(){
        log.info("Clicking on Register and Login link");
        click(registerLogin);
    }
}


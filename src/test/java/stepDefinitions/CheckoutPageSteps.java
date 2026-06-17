package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.LoggerUtil;

import org.apache.logging.log4j.Logger;

public class CheckoutPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(CheckoutPageSteps.class);

    public CheckoutPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @Then("I Verify that Cart Page is displayed")
    public void iVerifyThatCartPageIsDisplayed() {
        log.info("Verifying that Cart Page is displayed");
        //boolean actualMessage = baseClass.checkoutPage.isCartPageDisplayed();
        Assert.assertTrue("Cart Page is not displayed", baseClass.checkoutPage.isCartPageDisplayed());

    }

    @And("I Click on Proceed To Checkout button")
    public void iClickOnProceedToCheckoutButton() {
        log.info("Clicking on Proceed To Checkout button");
        baseClass.checkoutPage.clickProceedToCheckout();
    }

    @And("I Click on Register and Login")
    public void iClickOnRegisterLoginButton() {
        log.info("Clicking on Register and Login");
        baseClass.checkoutPage.clickRegisterLoginButton();
    }
}

















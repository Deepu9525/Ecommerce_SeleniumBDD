package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.LoggerUtil;

import org.apache.logging.log4j.Logger;

public class SubscriptionPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(SubscriptionPageSteps.class);

    public SubscriptionPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @When("I Scroll down to footer")
    public void i_scroll_down_to_footer() {
        log.info("Scroll down to footer");
        baseClass.homePage.scrollToFooter();
    }

    @Then("I Verify text {string}")
    public void i_verify_text(String excepted) {
        log.info("Verifying subscription text");
        String actualText = baseClass.homePage.getSubscriptionText();
        Assert.assertEquals(excepted, actualText);

    }

    @When("I Enter subscription email {string}")
    public void i_enter_subscription_email(String email) {
        log.info("Entering subscription email");
        baseClass.homePage.enterSubscriptionEmail(email);

    }

    @When("I Click on subscription arrow button")
    public void i_click_on_subscription_arrow_button() {
        log.info("Clicking on subscription arrow button");
        baseClass.homePage.clickSubscriptionSubmit();

    }

    @Then("I Verify success subscription message")
    public void i_verify_success_subscription_message() {
        log.info("Verifying subscription message successfully");
        boolean actualMessage = baseClass.homePage.isSubscribeSuccessMessageVisible();
        Assert.assertTrue(actualMessage);

    }

    @When("I Click on Cart button")
    public void iClickOnCartButton() {
       log.info("Clicking on cart button");
       baseClass.homePage.clickCartButton();
    }

}

package stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.LoggerUtil;
import utilities.TestDataRepo;

public class PaymentPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(PaymentPageSteps.class);

    public PaymentPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @And("I Enter payment details")
    public void iEnterPaymentDetails() {
        log.info("Entering payment details");
        JsonNode data = TestDataRepo.getPaymentDetailsData();
        baseClass.paymentPage.enterPaymentDetails(data);
    }

    @When("I Click on Pay and Confirm Order")
    public void iClickOnPayAndConfirmOrder() {
        log.info("Clicking on Pay and Confirm Order");
        baseClass.paymentPage.clickPayAndConfirmOrder();
    }

    @Then("I Verify order placed successfully")
    public void iVerifyOrderPlacedSuccessfully() {
       log.info("Verifying order successfully message and color");
       String color = baseClass.paymentPage.getOrderPlacedColor();
       String confirmMessage = baseClass.paymentPage.getOrderMessage();

       Assert.assertEquals("rgba(0, 128, 0, 1)", color);

       Assert.assertTrue(confirmMessage.contains("Congratulations! Your order has been confirmed!"));
    }
}

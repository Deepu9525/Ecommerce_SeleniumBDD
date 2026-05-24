package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.LoggerUtil;

import org.apache.logging.log4j.Logger;

public class CartPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(CartPageSteps.class);

    public CartPageSteps(BaseClass baseClass){
        this.baseClass= baseClass;
    }

    @Then("I Verify the both products are added to cart")
    public void iVerifyTheBothProductsAreAddedToCart() {
        Assert.assertTrue(baseClass.cartPage.verifyBothProductsAdded());

    }

    @And("I Verify their prices quantity and total price")
    public void iVerifyTheirPricesQuantityAndTotalPrice() {
        Assert.assertTrue(baseClass.cartPage.verifyPriceQuantityAndTotal());

    }

    @Then("I Verify the product quantity is {string} in cart")
    public void iVerifyTheProductQuantityIsInCart(String expectedQuantity) {
        log.info("Verifying product quantity in cart");
        String actualQuantity = baseClass.cartPage.getCartQuantity();
        log.info("Expected Quantity: " + expectedQuantity);
        log.info("Actual Quantity: " + actualQuantity);

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }
}



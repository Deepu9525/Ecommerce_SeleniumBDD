package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.LoggerUtil;

import org.apache.logging.log4j.Logger;

public class ProductsPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(ProductsPageSteps.class);

    public ProductsPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @When("I Click on Products button")
    public void i_click_on_products_button() {
        log.info("Clicking on Products");
        baseClass.productsPage.clickProducts();
    }

    @Then("I Verify user is navigated to all Products page successfully")
    public void i_verify_user_is_navigated_to_all_products_page_successfully() {
        log.info("Verifying all Products page");
        Assert.assertTrue(baseClass.productsPage.isAllProductsPageVisible());
    }

    @Then("I Verify Products list is visible")
    public void i_verify_products_list_is_visible() {
        log.info("Verifying Products list");
        Assert.assertTrue(baseClass.productsPage.isProductsListVisible());

    }

//    @When("I Click on View Product of first product")
//    public void i_click_on_view_product_of_first_product() {
//        log.info("Clicking on View Product");
//        baseClass.productsPage.clickFirstVieProduct();
//    }

    @Then("I Verify user is navigated to Product detail page")
    public void i_verify_user_is_navigated_to_product_detail_page() {
        String currentUrl = baseClass.driver.getCurrentUrl();
        log.info("Product detail page URL" + currentUrl);
        Assert.assertTrue(currentUrl.contains("product_details"));
    }

    @Then("I Verify Product name is visible")
    public void i_verify_product_name_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isProductNameVisible());
    }

    @Then("I Verify Category is visible")
    public void i_verify_category_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isCategoryVisible());
    }

    @Then("I Verify Price is visible")
    public void i_verify_price_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isPriceVisible());
    }

    @Then("I Verify Availability is visible")
    public void i_verify_availability_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isAvailabilityVisible());
    }

    @Then("I verify Condition is visible")
    public void i_verify_condition_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isConditionVisible());
    }

    @Then("I Verify Brand is visible")
    public void i_verify_brand_is_visible() {
        Assert.assertTrue(baseClass.productsPage.isBrandVisible());
    }

    @When("I Enter Product Name {string} in search")
    public void iEnterProductNameInSearch(String productName) {
        baseClass.productsPage.setProductName(productName);
    }

    @And("I Click on search button")
    public void iClickOnSearchButton() {
        baseClass.productsPage.clickSearchButton();
    }

    @Then("I Verify search Products text is visible")
    public void iVerifySearchProductsTextIsVisible() {
        log.info("Verifying search product test");
        Assert.assertTrue(baseClass.productsPage.isSearchProductTextVisible());

    }

    @And("I Verify all searched Products are related to {string}")
    public void iVerifyAllSearchedProductsAreRelatedTo(String productName) {
        Assert.assertTrue(baseClass.productsPage.verifySearchProducts(productName));
    }

    @And("I hover over {int} product and click Add to Cart")
    public void iHoverOverProductAndClickAddToCart(int productIndex) {
        baseClass.productsPage.hoverProduct(productIndex-1);
        baseClass.productsPage.clickMouseHoverProductsAddToCart(productIndex);
    }

    @And("I Click on Continue Shopping button")
    public void iClickOnContinueShoppingButton() {
       baseClass.productsPage.clickFirstProductContinueShopping();
    }


    @And("I Click on View Cart button")
    public void iClickOnViewCartButton() {
        baseClass.productsPage.clickViewCartMouseHover();
    }

    @When("I Click on View Product of product number {int}")
    public void iClickOnViewProductOfProductNumber(int productIndex) {
        baseClass.productsPage.clickViewProduct(productIndex);
    }

    @And("I Increase product quantity to {string}")
    public void iIncreaseProductQuantityTo(String quantity) {
       baseClass.productsPage.enterQuantity(quantity);
    }

    @When("I Click on Add to Cart button")
    public void iClickOnAddToCartButton() {
        baseClass.productsPage.clickAddCart();
    }

}


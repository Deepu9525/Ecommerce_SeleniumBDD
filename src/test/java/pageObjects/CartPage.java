package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestDataRepo;

import java.util.List;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By cartRows = By.cssSelector("[class='table table-condensed'] tbody tr");

    By cartProductItems = By.xpath("//img[@class='product_image']");

    By cartProductNames = By.cssSelector("[class='cart_description'] h4 a");

    By cartPrices = By.cssSelector("[class='cart_price'] p");

    By cartQuantity = By.cssSelector("[class='cart_quantity'] button");

    By cartTotal = By.cssSelector("[class='cart_total'] p");

    By deliveryAddress = By.xpath("//ul[@class='address item box' and @id='address_delivery']");

    By billingAddress = By.cssSelector("[class='address alternate_item box']");

    By reviewOrderHeading = By.xpath("//*[contains(text(), 'Review Your Order')]");

    By comment = By.cssSelector(".form-control[name='message']");

    By placeOrder = By.cssSelector(".btn.btn-default.check_out");

    //Actions
    public boolean verifyBothProductsAdded(){
        log.info("Verifying both products are added");
        List<WebElement> rows = getElements(cartRows);
        log.info("Total products in cart: " + rows.size());
        return rows.size() == 2;
    }

    public boolean verifyPriceQuantityAndTotal(){
        log.info("Verifying prices quantity and total");
        List<WebElement> productItems = getElements(cartProductItems);
        List<WebElement> productNames = getElements(cartProductNames);
        List<WebElement> prices = getElements(cartPrices);
        List<WebElement> quantities = getElements(cartQuantity);
        List<WebElement> totals = getElements(cartTotal);

        for(int i=0;i<prices.size();i++) {
            String productItemsImage = productItems.get(i).getAttribute("src");
            String productNamesText = productNames.get(i).getText().trim();
            String priceText = prices.get(i).getText().replace("Rs. ", "").trim();
            String quantityText = quantities.get(i).getText().trim();
            String totalText = totals.get(i).getText().replace("Rs. ", "").trim();


            int price = Integer.parseInt(priceText);
            int quantity = Integer.parseInt(quantityText);
            int actualTotal = Integer.parseInt(totalText);

            int expectedTotal = price * quantity;

            //log.info("Product " + (i + 1));
            log.info("Product Items: " + productItemsImage);
            log.info("Product Names: " + productNamesText);
            log.info("Price: " + price);
            log.info("Quantity: " + quantity);
            log.info("Expected Total: " + expectedTotal);
            log.info("Actual Total: " + actualTotal);

            if (expectedTotal != actualTotal) {
                log.error("Price total mismatch for product : " + productNamesText);
                return false;
            }
        }


        log.info("Prices, quantity and total verified successfully");

        return true;

    }

    public String getCartQuantity(){
        log.info("Getting cart quantity");
        return getText(cartQuantity).trim();
    }

    public  String getDeliveryAddressText(){
        return waitForVisibility(deliveryAddress).getText();
    }

    public String getBillingAddressText(){
        return waitForVisibility(billingAddress).getText();
    }

    public void verifyAddressDetails(String addressText){
        var data = TestDataRepo.getSignupData();

        String[] expectedValues = {
                data.get("title").asText(),
                data.get("firstName").asText(),
                data.get("lastName").asText(),
                data.get("company").asText(),
                data.get("address").asText(),
                data.get("city").asText(),
                data.get("state").asText(),
                data.get("zipCode").asText(),
                data.get("countryName").asText(),
                data.get("mobileNum").asText()

        };

        for (String value : expectedValues) {
            log.info("Verifying: {}", value);
            Assert.assertTrue(
                    "Expected value not found: " + value,
                    addressText.contains(value)
            );
        }

    }

    public void verifyAddressDetailsInCartPage(){
        String deliveryAddress = getDeliveryAddressText();
        String billingAddress = getBillingAddressText();

        log.info("========== DELIVERY ADDRESS ==========");
        log.info("\n{}", deliveryAddress);

        log.info("========== BILLING ADDRESS ==========");
        log.info("\n{}", billingAddress);

        //verify Delivery and Billing Address
        log.info("Verifying Delivery Address...");
        verifyAddressDetails(deliveryAddress);
        log.info("Verifying Billing Address...");
        verifyAddressDetails(billingAddress);

        log.info("Delivery and Billing addresses verified successfully");

    }

    public boolean verifyReviewOrderSection() {
        log.info("Verifying Review Order section");
        boolean reviewOrderDisplayed = isDisplayed(reviewOrderHeading);

        List<WebElement>  rows = getElements(cartRows);
        log.info("Products displayed in Review Order section: " + rows.size());

        return reviewOrderDisplayed && !rows.isEmpty();

    }

    public void enterCommentForOrder(String commentText){
        log.info("Entering comment for order");
        type(comment, commentText);
    }

    public void clickPlaceOrderButton(){
        log.info("Clicking the Place order button");
        click(placeOrder);
    }
}

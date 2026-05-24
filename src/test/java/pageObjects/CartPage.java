package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

}

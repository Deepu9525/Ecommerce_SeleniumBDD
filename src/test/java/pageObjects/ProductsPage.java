package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By productsButton = By.cssSelector("a[href='/products']");

    By productsHeading = By.xpath("//h2[@class='title text-center']");

    By productsList = By.cssSelector("div.features_items");

    By viewFirstProduct = By.cssSelector("[href='/product_details/1']");
    By viewProducts = By.xpath("//a[contains(@href,'/product_details/')]");

    By productName = By.cssSelector("[class='product-information'] h2");

    By category = By.cssSelector("div.product-information > p:first-of-type");

    By price = By.cssSelector("div.product-details > div.col-sm-7 > div > span > span");

    By availability = By.cssSelector(".product-information p:nth-of-type(2)");
    //Css .product-information p:nth-child(6)

    By condition = By.cssSelector(".product-information p:nth-of-type(3)");

    By brand = By.cssSelector(".product-information p:nth-of-type(4)");

    By searchInput = By.cssSelector("[id='search_product']");

    By searchButton = By.cssSelector("[id='submit_search']");

    By searchProductText = By.cssSelector("[class='title text-center']");

    By productNames = By.xpath("//div[@class='productinfo text-center']/p");

    By productsMouseHover = By.cssSelector("[class='product-image-wrapper']");

    //By firstProductAddCart = By.cssSelector("[class='product-overlay'] [data-product-id='1']");
    By mouseHoverProductsAddCart = By.cssSelector("[class='product-overlay'] [class='btn btn-default add-to-cart']");

    By firstProductContinueShopping = By.cssSelector("[class='btn btn-success close-modal btn-block']");

    By productsMouseHoverViewCart = By.cssSelector("[class='text-center'] [href='/view_cart']");

    By quantity = By.xpath("//input[@id='quantity']");

    By addCart = By.cssSelector("[class='btn btn-default cart']");

    //Actions
    public void clickProducts(){
        log.info("Clicking on Products");
        click(productsButton);
    }

    public boolean isAllProductsPageVisible(){
        log.info("Verifying Products page visible");
        return isDisplayed(productsHeading);
    }

    public boolean isProductsListVisible() {
        log.info("Verifying Products list is visible");
        return isDisplayed(productsList);
    }

    public void clickViewProduct(int productIndex){
        log.info("Clicking on view product: " + productIndex);
        List<WebElement> products = getElements(viewProducts);
        WebElement product = products.get(productIndex - 1);
        //Actions action = new Actions(driver);
        //action.moveToElement(product).click().build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", product);
        js.executeScript("arguments[0].click();", product);
    }

    public boolean isProductNameVisible(){
        log.info("Verifying Product name");
        return isDisplayed(productName);
    }

    public boolean isCategoryVisible(){
        log.info("Verifying Category");
        return isDisplayed(category);
    }

    public boolean isPriceVisible(){
        log.info("Verifying Price");
        return isDisplayed(price);
    }

    public boolean isAvailabilityVisible(){
        log.info("Verifying Availability");
        return isDisplayed(availability);
    }

    public boolean isConditionVisible(){
        log.info("Verifying Condition is visible");
        return isDisplayed(condition);
    }

    public boolean isBrandVisible() {
        log.info("Verifying brand");
        return isDisplayed(brand);
    }

    public void setProductName(String productName){
        type(searchInput, productName);
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public boolean isSearchProductTextVisible(){
        log.info("Verifying search product text");
        return isDisplayed(searchProductText);
    }

//    public boolean verifySearchProducts(String productNamesList){
//        log.info("Verifying product names");
//        List<WebElement> products = getElements(productNames);
//        boolean productMatched = false;
//        for(WebElement product: products){
//            String actualProduct = product.getText().toLowerCase();
//            log.info("Product Found: " + actualProduct);
//
//            if(actualProduct.contains(productNamesList.toLowerCase())){
//                productMatched = true;
//            }else{
//                log.warn("Irrelevant product found: " + actualProduct);
//            }
//        }
//        return productMatched;
//
//    }

    public boolean verifySearchProducts(String productNamesList){

        log.info("Verifying product names");

        List<WebElement> products = getElements(productNames);

        int matchedCount = 0;

        for(WebElement product : products){

            String actualProduct = product.getText().toLowerCase();

            log.info("Product Found: " + actualProduct);

            if(actualProduct.contains(productNamesList.toLowerCase())){

                matchedCount++;

            } else {

                log.warn("Irrelevant product found: " + actualProduct);
            }
        }

        log.info("Total matched products: " + matchedCount);

        return matchedCount > 0;
    }

    public void hoverProduct(int index){
        log.info("Hovering on product: " + index);
        List<WebElement> products = getElements(productsMouseHover);
        WebElement product = products.get(index);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", product);

        Actions action = new Actions(driver);
        action.moveToElement(product).perform();
    }

    public void clickMouseHoverProductsAddToCart(int productIndex){
        log.info("Clicking on products Add Cart");
        List<WebElement> addCartButtons = getElements(mouseHoverProductsAddCart);
        WebElement addToCart = addCartButtons.get(productIndex-1);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript("arguments[0].scrollIntoView(true);", addToCart);

        js.executeScript("arguments[0].click();", addToCart);
        //addCartButtons.get(productIndex - 1).click();
    }


//    public void clickFirstProductAddCart(){
//        click(firstProductAddCart);
//    }

    public void clickFirstProductContinueShopping(){
        log.info("Clicking on first product continue shopping");
        click(firstProductContinueShopping);
    }

    public void clickViewCartMouseHover(){
        log.info("Clicking on mouse hover view cart");
        click(productsMouseHoverViewCart);
    }

    public void enterQuantity(String quantityInput){
        log.info("Entering quantity: " + quantityInput);
        type(quantity,quantityInput);
    }

    public void clickAddCart(){
        log.info("Clicking on Add cart");
        click(addCart);
    }

}

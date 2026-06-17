package pageObjects;

import com.fasterxml.jackson.databind.JsonNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage{

    public PaymentPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By nameOnCard = By.cssSelector("[class='form-control'][name='name_on_card']");

    By cardNumber = By.cssSelector(".form-control.card-number[name='card_number']");

    By cardCvc = By.xpath("//div[@class='col-sm-4 form-group cvc']/child::input");

    By eMonth = By.xpath("//input[@class='form-control card-expiry-month' and @name='expiry_month']");

    By eYear = By.name("expiry_year");

    By payAndConfirmOrder = By.cssSelector("[id='submit']");

    By orderPlacedText = By.cssSelector("[data-qa='order-placed']");

    By orderConfirmMessage = By.xpath("//p[contains(text(), 'Congratulations!')]");

    //Actions
    public void enterPaymentDetails(JsonNode data){
        log.info("Entering payment details");

        type(nameOnCard, data.get("cardName").asText());
        type(cardNumber, data.get("cardNum").asText());
        type(cardCvc, data.get("cvc").asText());
        type(eMonth, data.get("month").asText());
        type(eYear, data.get("year").asText());

    }

    public void clickPayAndConfirmOrder(){
        log.info("Clicking the pay and confirm order");
        click(payAndConfirmOrder);
    }

    public String getOrderPlacedColor(){
        log.info("Verifying order placed color");
        return getElement(orderPlacedText).getCssValue("color");
    }

    public String getOrderMessage(){
        log.info("Verifying order successfully");
        return getText(orderConfirmMessage);
    }
}

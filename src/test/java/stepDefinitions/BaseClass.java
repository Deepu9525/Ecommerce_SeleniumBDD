package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class BaseClass {
    public WebDriver driver;

    //Page Object Class references
    public HomePage homePage;
    public RegistrationFormPage registrationPage;
    public SignupLoginPage signupLoginPage;
    public LoginPage loginPage;
    public TestCasesPage testCasesPage;
    public ProductsPage productsPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public PaymentPage paymentPage;
}


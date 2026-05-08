package stepDefinitions;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationFormPage;
import pageObjects.SignupLoginPage;

public class BaseClass {
    public WebDriver driver;

    //Page Object Class references
    public HomePage homePage;
    public RegistrationFormPage registrationPage;
    public SignupLoginPage signupLoginPage;
    public LoginPage loginPage;
}


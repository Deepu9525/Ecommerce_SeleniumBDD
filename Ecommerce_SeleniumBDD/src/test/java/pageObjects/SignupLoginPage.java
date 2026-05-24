package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupLoginPage extends BasePage{

    //Constructor
    public SignupLoginPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By signupFormVisible = By.xpath("//div[@class='signup-form']");
    //CSS Selectors: div[class='signup-form'] >h2,   div.signup-form

    By signupHeading = By.xpath("//h2[normalize-space()='New User Signup!']");

    By signupName = By.cssSelector("input[placeholder='Name']");
    By signupEmail = By.cssSelector("[data-qa='signup-email'][placeholder='Email Address']");

    By clickSignupButton = By.xpath("//button[@data-qa='signup-button']");

    By emailAlreadyExitsError = By.cssSelector("[class='signup-form'] p");

    //Actions
    public boolean isSignupSectionVisible(){
        log.info("Checking Signup form and heading is displayed");
        return isDisplayed(signupFormVisible) && isDisplayed(signupHeading);
    }


    public void enterSignupDetails(String Name, String Email){
        log.info("Entering Name and Email for Signup");
        type(signupName,Name);
        type(signupEmail, Email);
        //driver.findElement(signupEmail).sendKeys(Email);
    }

    public void clickSignup(){
        //driver.findElement(clickSignupButton).click();
        log.info("Clicking on Signup button ");
        click(clickSignupButton);
    }

    public String getEmailAlreadyExists(){
        log.info("Verifying Email Already Exits message: ");
        return getText(emailAlreadyExitsError);
    }

}

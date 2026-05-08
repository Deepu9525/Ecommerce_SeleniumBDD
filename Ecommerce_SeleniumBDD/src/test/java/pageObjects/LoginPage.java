package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
       super(driver);
    }

    //Locators
    By loginAccountVisible = By.cssSelector("div.login-form h2");

    By loginEmail = By.cssSelector("[data-qa='login-email']");
    By loginPassword = By.cssSelector("[data-qa='login-password']");

    By login = By.cssSelector("[data-qa='login-button']");

    By loginError = By.cssSelector(".login-form p");

    //Actions
    public boolean isLoginAccountVisible(){
        log.info("Verifying Login form visible........");
        return isDisplayed(loginAccountVisible);
    }

    public void login(String email, String password){
        type(loginEmail,email);
        type(loginPassword, password);
    }

    public void clickLogin(){
        click(login);
    }

    public String getLoginErrorMessage(){
        return getText(loginError);
    }

}

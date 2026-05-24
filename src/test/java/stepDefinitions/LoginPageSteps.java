package stepDefinitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;
import utilities.ScenarioContent;
import utilities.TestDataRepo;

public class LoginPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(LoginPageSteps.class);

    public LoginPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @Then("I Verify the Login page Visible")
    public void i_verify_the_login_page_visible() {
        log.info("Verifying Login page");
        boolean isVisible = baseClass.loginPage.isLoginAccountVisible();
        Assert.assertTrue("Login text is not Visible: ", isVisible);

    }

    @When("I Enter Login Credentials with Password {string}")
    public void i_enter_login_credentials_with_password(String password) {
        String userType = (String) ScenarioContent.getData("userType");

        String email;
        if(userType.equalsIgnoreCase("Valid")){
            email = (String) ScenarioContent.getData("email");
        }else
            email = "invaliduser" + System.currentTimeMillis() + "@gmail.com";

        System.out.println("EMAIL USED = " + email);
        System.out.println("PASSWORD USED = " + password);

        baseClass.loginPage.login(email, password);
    }


    @Then("I Verify {string}")
    public void i_verify(String expected) {
        if(expected.contains("Logged in")) {

            String actual = baseClass.registrationPage.getLoggedInUserText();
            String expectedName = TestDataRepo.getSignupData().get("name").asText();

            Assert.assertTrue(actual.contains(expectedName));

        } else {

            String actualError = baseClass.loginPage.getLoginErrorMessage();

            Assert.assertTrue(
                    "Error not matched",
                    actualError.contains(expected)
            );
        }

    }

}


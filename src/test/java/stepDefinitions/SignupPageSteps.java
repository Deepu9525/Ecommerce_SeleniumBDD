package stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.*;

public class SignupPageSteps{

    BaseClass baseClass;
    JsonNode signupData;

    Logger log = LoggerUtil.getLogger(SignupPageSteps.class);

    public SignupPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
        this.signupData = TestDataRepo.getSignupData();
    }

    @Then("I Verify the Signup form and heading on the Signup and Login Screen")
    public void iVerifyTheNewUserSignupHeadingOnTheSignupAndLoginScreen() {
        log.info("Verifying Signup form is visible:");
        Assert.assertTrue("Signup form not visible", baseClass.signupLoginPage.isSignupSectionVisible());

    }

    @When("I Enter valid Name and Email on the Signup and Login Screen")
    public void iEnterValidNameAndEmailOnTheSignupAndLoginScreen() {
        // Fetch values from JSON
        String name = signupData.get("name").asText();
        String email = DataUtil.getEmail(UserType.NEW);
        ScenarioContent.setData("email", email); //store
        baseClass.signupLoginPage.enterSignupDetails(name, email);
    }

    @And("I Click on Signup")
    public void iClickOnSignup() {
        baseClass.signupLoginPage.clickSignup();

    }

    @When("I Enter valid Name and already registered Email")
    public void iEnterValidNameAndAlreadyRegisteredEmail() {
       String name = signupData.get("name").asText();
       String email = (String) ScenarioContent.getData("email"); //reuse

       baseClass.signupLoginPage.enterSignupDetails(name, email);
    }

    @Then("I Verify error message {string}")
    public void iVerifyErrorMessageEmailAddressAlreadyExist(String expectMsg) {
        String actualMsg = baseClass.signupLoginPage.getEmailAlreadyExists();
        log.info("Verifying Email already exite: " + actualMsg);
        Assert.assertTrue(actualMsg.contains(expectMsg));
    }

    @And("I Click on Login")
    public void iClickOnLogin() {
        log.info("clicking on Login");
        baseClass.loginPage.clickLogin();
        System.out.println(baseClass.driver.getCurrentUrl());
    }


}











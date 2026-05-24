package stepDefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.RegistrationFormPage;
import utilities.DataUtil;
import utilities.ScenarioContent;
import utilities.TestDataRepo;
import utilities.UserType;

public class RegistrationPageSteps {

    private static final Logger log = LoggerFactory.getLogger(RegistrationPageSteps.class);
    BaseClass baseClass;

    public RegistrationPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @Then("I Verify the Enter Account Information on the Registration Screen")
    public void i_verify_the_enter_account_information_on_the_registration_screen() {
       boolean isVisible = baseClass.registrationPage.isAccountInformationVisible();
        Assert.assertTrue("Enter Account Information is not visible", isVisible);
    }

    @When("I Enter all Registration details on the Registration Screen")
    public void iEnterAllRegistrationDetailsOnTheRegistrationScreen() {
        var data = utilities.TestDataRepo.getSignupData();

        baseClass.registrationPage.selectTitle(data.get("title").asText());
        baseClass.registrationPage.enterPassword(data.get("password").asText());
        baseClass.registrationPage.selectDateOfBirth(
                data.get("days").asText(),
                data.get("months").asText(),
                data.get("years").asText()
        );


        baseClass.registrationPage.selectCheckbox(
                RegistrationFormPage.CheckboxOption.NEWSLETTER,
                RegistrationFormPage.CheckboxOption.OFFERS
                );

        baseClass.registrationPage.enterAddressInformation(
                data.get("firstName").asText(),
                data.get("lastName").asText(),
                data.get("company").asText(),
                data.get("address").asText(),
                data.get("state").asText(),
                data.get("city").asText(),
                data.get("zipCode").asText(),
                data.get("mobileNum").asText(),
                data.get("countryName").asText()
        );
    }

    @And("I Click on the Create Account on the Signup Login Screen")
    public void iClickOnTheCreateAccountOnTheSignupLoginScreen() {
        baseClass.registrationPage.clickCreateAccount();
    }

    @Then("I Verify the Account Created message on the Signup Login Screen")
    public void iVerifyTheAccountCreatedMessageOnTheSignupLoginScreen() {
       String text = baseClass.registrationPage.getAccountCreatedText();
       Assert.assertTrue("Account created text is not visible",
                text.contains("ACCOUNT CREATED"));
    }

    @When("I Click on the Continue button")
    public void iClickOnTheContinueButton() {
        baseClass.registrationPage.clickContinue();
    }

    @And("I Verify the Continue button is displayed on the Signup Login Screen")
    public void iVerifyTheContinueButtonIsDisplayedOnTheSignupLoginScreen() {
        boolean visible = baseClass.registrationPage.isContinueButtonDisplayed();
        Assert.assertTrue("Continue button is not displayed", visible);
    }

    @And("I Verify the Logged in UserName on the Home Screen")
    public void iVerifyTheLoggedInUserNameOnTheHomeScreen() {
        String actualText = baseClass.registrationPage.getLoggedInUserText();
        String exceptedText = TestDataRepo.getSignupData().get("name").asText();
        Assert.assertTrue("Excepted username not found:" +actualText,actualText.contains(exceptedText));
    }

    @And("I Click on the Delete Account on the Home Screen")
    public void iClickOnTheDeleteAccountOnTheHomeScreen() {
        baseClass.registrationPage.clickDeleteAccount();
    }

    @And("I Verify the Account Deleted message")
    public void iVerifyTheAccountDeletedMessage() {
       String text = baseClass.registrationPage.getAccountDeletedText();
       Assert.assertTrue("Account deleted text is not visible", text.contains("ACCOUNT DELETED"));
    }

    @When("I prepare user setup for {string} with password {string}")
    public void i_prepare_user_setup_for_with_password(String userType, String password) {
        ScenarioContent.setData("userType", userType);

        //Only register for SUCCESS case
        if (userType.equalsIgnoreCase("Valid")) {
            var data = utilities.TestDataRepo.getSignupData();

            String name = data.get("name").asText();
            String email = DataUtil.getEmail(UserType.NEW);

            ScenarioContent.setData("email", email); //store

            baseClass.signupLoginPage.enterSignupDetails(name, email);
            baseClass.signupLoginPage.clickSignup();

            baseClass.registrationPage.selectTitle(data.get("title").asText());

            //Password from Examples
            baseClass.registrationPage.enterPassword(password);

            baseClass.registrationPage.selectDateOfBirth(
                    data.get("days").asText(),
                    data.get("months").asText(),
                    data.get("years").asText()
            );

            baseClass.registrationPage.selectCheckbox(
                    RegistrationFormPage.CheckboxOption.NEWSLETTER,
                    RegistrationFormPage.CheckboxOption.OFFERS
            );

            baseClass.registrationPage.enterAddressInformation(
                    data.get("firstName").asText(),
                    data.get("lastName").asText(),
                    data.get("company").asText(),
                    data.get("address").asText(),
                    data.get("state").asText(),
                    data.get("city").asText(),
                    data.get("zipCode").asText(),
                    data.get("mobileNum").asText(),
                    data.get("countryName").asText()
            );

            baseClass.registrationPage.clickCreateAccount();

            //verify account created
            Assert.assertTrue(baseClass.registrationPage.getAccountCreatedText().contains("ACCOUNT CREATED"));

            baseClass.registrationPage.clickContinue();

            //wait until logged in user visible
            Assert.assertTrue(baseClass.registrationPage.isLoggedInUserVisible());

            baseClass.homePage.clickLogout();
            //baseClass.homePage.clickSignupLogin();

            Assert.assertTrue(
                    baseClass.loginPage.isLoginAccountVisible()
            );
        }

    }

}


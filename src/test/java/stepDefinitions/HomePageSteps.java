package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.LoggerUtil;

import org.apache.logging.log4j.Logger;

public class HomePageSteps{

    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(HomePageSteps.class);

    public HomePageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @Given("I Launch the browser")
    public void i_launch_the_browser() {
        log.info("Launching browser");
        // Browser is already launched in Hooks @Before
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//
//        homePage = new HomePage(driver);
//        registrationPage = new RegistrationPage(driver);
//        signupLoginPage = new SignupLoginPage(driver);
    }

    @When("I Open the Automation Exercise application")
    public void i_open_the_automation_exercise_application() {
        log.info("Opening application");
        //driver.get("https://automationexercise.com/");
        // Already opened in Hooks @Before
    }

    @And("I Verify the Home Page Logo on the Home Screen")
    public void iVerifyTheHomePageLogoOnTheHomeScreen() {
        log.info("Verifying Home Page Logo is visible");
        boolean isLogoDisplayed = baseClass.homePage.isLogoVisible();
        Assert.assertTrue("Logo is not visible", isLogoDisplayed);

    }

    @And("I Click on Signup and Login on the Home Screen")
    public void iClickOnSignupLoginOnTheHomeScreen() {
        log.info("Clicking on Signup");
        baseClass.homePage.clickSignupLogin();
    }

    @And("I Close the browser")
    public void iCloseTheBrowser() {
        log.info("Closing the browser");
       //driver.quit();
        //No need to close here, Hooks @After will quit the driver
    }

    @Then("I Verify the user is logged out on the Home Screen")
    public void iVerifyTheUserIsLoggedOutOnTheHomeScreen() {
       boolean signupVisible = baseClass.homePage.isSignupLoginVisible();
       Assert.assertTrue("User is still logged in", signupVisible);
    }

    @And("I Click on the Logout")
    public void iClickOnTheLogout() {
      log.info("Clicking on logout");
      baseClass.homePage.clickLogout();
    }

}



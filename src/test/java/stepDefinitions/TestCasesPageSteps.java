package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class TestCasesPageSteps {
    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(TestCasesPageSteps.class);

    public TestCasesPageSteps(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    @When("I Click on the test Cases on the HomePage")
    public void iClickOnTheTestCasesOnTheHomePage() {
        log.info("Clicking on TesCases button");
        baseClass.testCasesPage.clickTestCases();
    }

    @Then("I Verify user is navigated to Test Cases page successfully")
    public void iVerifyUserIsNavigatedToTestCasesPageSuccessfully() {
        log.info("Verifying TestCases homepage and url");
        boolean status = baseClass.testCasesPage.isTestCaseHeadingVisible();
        Assert.assertTrue("Test Cases heading is not visible", status);

        log.info("Test Cases page verified successfully");
        String expectedUrl = "https://automationexercise.com/test_cases";

        String actualUrl = baseClass.driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl, actualUrl);
    }
}

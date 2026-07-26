package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/Features/Login.feature", "src/test/resources/Features/RegistrationUser.feature"},
        glue={"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
                "html:reports/cucumber-reports/cucumber.html",
                "json:reports/cucumber-reports/cucumber.json"},
        tags="@register and @sanity"
)
public class TestRunner {

}

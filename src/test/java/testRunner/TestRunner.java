package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/resources/Features/Products.feature",
        glue={"stepDefinitions"},
        dryRun = false,
        monochrome = true,
        plugin = {"pretty",
                "html:reports/cucumber-reports/cucumber.html",
                "json:reports/cucumber-reports/cucumber.json"}
)
public class TestRunner {

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage{

    public TestCasesPage(WebDriver driver){
        super(driver);
    }

    //Locators
    By testCases = By.xpath("//li//a[@href='/test_cases']");

    By testCasesHeading = By.xpath("//h2[@class='title text-center']/b");

    //Actions
    public void clickTestCases(){
        log.info("Clicking on TestCases");
        click(testCases);
    }

    public boolean isTestCaseHeadingVisible(){
        log.info("Verifying Testcase Page");
        return isDisplayed(testCasesHeading);
    }

}

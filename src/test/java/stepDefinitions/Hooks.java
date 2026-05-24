package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.*;
import utilities.*;

import org.apache.logging.log4j.Logger;

public class Hooks{

    BaseClass baseClass;

    Logger log = LoggerUtil.getLogger(Hooks.class);

    public Hooks(BaseClass baseClass){
        this.baseClass = baseClass;
        log.info("Hooks received BaseClass instance: " + baseClass);
    }

    @Before
    public void setup(){
        log.info("Test started");

        //baseClass.driver = new ChromeDriver(); ///this is before creating DriverFactory class
        String browser = System.getProperty("browser", ConfigReader.getBrowser()); // default chrome

        DriverFactory.initDriver(browser);
        baseClass.driver = DriverFactory.getDriver();

        baseClass.driver.manage().window().maximize();
        baseClass.driver.manage().deleteAllCookies();
        //baseClass.driver.get("https://automationexercise.com");
        baseClass.driver.get(ConfigReader.getUrl());

        //Initialize all Page Objects once per scenario
        baseClass.homePage = new HomePage(baseClass.driver);
        baseClass.loginPage = new LoginPage(baseClass.driver);
        baseClass.registrationPage = new RegistrationFormPage(baseClass.driver);
        baseClass.signupLoginPage = new SignupLoginPage(baseClass.driver);
        baseClass.testCasesPage = new TestCasesPage(baseClass.driver);
        baseClass.productsPage = new ProductsPage(baseClass.driver);
        baseClass.cartPage = new CartPage(baseClass.driver);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte[] screenshot = ScreenshotUtil.captureScreenshot(baseClass.driver, scenario.getName());
            log.error("Test Failed: "+ scenario.getName());
            scenario.attach(screenshot, "image/png", scenario.getName());
        }else{
            log.info("Test Passed:" + scenario.getName());
        }

        log.info("Test Finished");
        DriverFactory.quitDriver();
    }

}

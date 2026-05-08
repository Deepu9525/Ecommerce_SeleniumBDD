package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationFormPage extends BasePage{

    //Logger log = LoggerUtil.getLogger(RegistrationPage.class);

    //Constructor
    public RegistrationFormPage(WebDriver driver){
        super(driver);

    }

    public enum CheckboxOption {
        NEWSLETTER,
        OFFERS
    }

    //Locators
    By signupAccountIsVisible = By.cssSelector("h2.title.text-center > b");

    By titleMr = By.cssSelector("[name='title'][value='Mr']");
    By titleMrs = By.cssSelector("[name='title'][value='Mrs']");
    //Xpath //input[@name='title' and @value='Mr']

    By password = By.cssSelector("[id='password']");

    By day = By.id("days");
    By month = By.id("months");
    By year = By.id("years");

    By newsletter = By.cssSelector("[id='newsletter']");
    By offers = By.cssSelector("[id='optin']");

    By firstName = By.cssSelector("[id='first_name']");
    By lastName = By.cssSelector("[id='last_name']");

    By company = By.xpath("//input[@id='company']");
    By address = By.xpath("//input[@id='address1']");
    By country = By.cssSelector("[name='country']");
    By state = By.cssSelector("[name='state']");
    By city = By.cssSelector("[id='city']");
    By zipCode = By.xpath("//input[@id='zipcode']");
    By mobileNum = By.cssSelector("input#mobile_number");
    By createAccount= By.cssSelector("[data-qa='create-account']");
    ////button[text()='Create Account']

    By accountCreatedText = By.cssSelector("[data-qa='account-created']");
    By continueButton = By.cssSelector("[data-qa='continue-button']");

    By loggedInUser = By.xpath("//a[contains(text(), 'Logged in as')]");
    By deleteAccount = By.xpath("//a[contains(text(), 'Delete Account')]");

    By accountDeleted = By.cssSelector("[data-qa='account-deleted']");

    //Actions
    public boolean isAccountInformationVisible(){
        log.info("Checking Signup form visible");
        return isDisplayed(signupAccountIsVisible);
    }

    public void selectTitle(String title){
        log.info("Selecting title: " + title);
        if(title.equalsIgnoreCase("Mr")){
            click(titleMr);
        }else if(title.equalsIgnoreCase("Mrs")){
            click(titleMrs);
        }else{
            throw new IllegalArgumentException("Invalid title: " + title);
        }
    }

    public void enterPassword(String pwd){
        log.info("Enter password");
        type(password, pwd);
    }

    public void selectDateOfBirth(String days, String months, String years){
        log.info("selecting Dob: ");
        Select daySelect = new Select(waitForVisibility(day));
        daySelect.selectByValue(days);
        log.info("selecting Dob: ");

        Select monthSelect = new Select(waitForVisibility(month));
        monthSelect.selectByVisibleText(months);
        log.info("selecting Dob: ");

        Select yearSelect = new Select(waitForVisibility(year));
        yearSelect.selectByVisibleText(years);
    }

    public void selectCheckbox(CheckboxOption... options) {
        log.info("Selecting checkboxes");
        for (CheckboxOption option: options){
            By checkBox;
            switch (option) {
                case NEWSLETTER -> checkBox = newsletter;
                case OFFERS -> checkBox = offers;
                default -> throw new IllegalArgumentException("Invalid option");
                }

                    if (!waitForVisibility(checkBox).isSelected()) {
                        click(checkBox);
                    }
        }

    }

    public void enterAddressInformation(String firstname, String lastname, String comp, String addr, String st, String cty, String zpCode, String mobile, String countryName){
        log.info("Entering address");
        type(firstName, firstname);
        type(lastName, lastname);
        type(company, comp);
        type(address, addr);
        type(state, st);
        type(city, cty);
        type(zipCode, zpCode);
        type(mobileNum, mobile);
        selectCountry(countryName);

    }

    public void selectCountry(String countryName){
        Select countryDropdown = new Select(waitForVisibility(country));
        countryDropdown.selectByVisibleText(countryName);
    }

    public void clickCreateAccount(){
        click(createAccount);
    }

    public String getAccountCreatedText(){
        return waitForVisibility(accountCreatedText).getText();
    }

    public boolean isContinueButtonDisplayed(){
        return isDisplayed(continueButton);
    }

    public void clickContinue(){
        click(continueButton);
    }

    public String getLoggedInUserText(){
        return waitForVisibility(loggedInUser).getText();
    }

    public boolean isLoggedInUserVisible(){
        return isDisplayed(loggedInUser);
    }

    public void clickDeleteAccount(){
        click(deleteAccount);
    }

    public String getAccountDeletedText(){
        return waitForVisibility(accountDeleted).getText();
    }
}

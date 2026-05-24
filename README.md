# Ecommerce Selenium BDD Automation Framework

Automation Testing Framework built using Selenium WebDriver + Cucumber BDD + Page Object Model (POM).

This project automates end-to-end testing of the Ecommerce website:

https://automationexercise.com

---

## Project Highlights

✔ Selenium + Cucumber BDD Framework  
✔ Page Object Model (POM)  
✔ Cross Browser Support (Chrome / Firefox / Edge)  
✔ Dynamic Test Data Generation  
✔ JSON Data Driven Testing  
✔ Screenshot Capture on Failure  
✔ HTML & JSON Reporting  
✔ Log4j2 Logging  
✔ Reusable Utility Components

---

## Tech Stack

- Java 21
- Selenium WebDriver 4
- Cucumber BDD
- JUnit
- Maven
- Page Object Model (POM)
- Log4j2
- Jackson JSON
- PicoContainer
- Git & GitHub

---

## Framework Architecture

```
Feature Files
      ↓
Step Definitions
      ↓
Page Objects
      ↓
Utilities
      ↓
WebDriver
```
---

## Project Structure

```text
Ecommerce_SeleniumBDD
│
├── src
│   └── test
│       ├── java
│       │   ├── pageObjects
│       │   ├── stepDefinitions
│       │   ├── utilities
│       │   └── testRunner
│       │
│       └── resources
│           ├── Features
│           ├── config.properties
│           ├── log4j2.xml
│           └── TestData.json
│
├── reports
├── pom.xml
└── README.md
```
---

## Automated Test Scenarios

### User Registration
- Register new user
- Register existing email validation
- Delete account

### Login / Logout
- Login with valid credentials
- Login with invalid credentials
- Verify error message
- Logout successfully

### Products
- Verify Products page
- Verify Product details
- Search Products
- Add Products to Cart
- Verify Quantity in Cart

### Cart
- Validate products added
- Validate price × quantity

### Subscription
- Verify subscription in Home page
- Verify subscription in Cart page

### Test Cases
- Verify Test Cases page navigation

---

## Utilities

### DriverFactory
Supports:
- Chrome
- Firefox
- Edge

### ConfigReader
Reads:
- Browser
- URL
- Timeout

### LoggerUtil
Handles execution logs.

### ScreenshotUtil
Captures screenshots on failure.

### TestDataRepo
Loads JSON test data.

### ScenarioContent
Stores runtime data.

### DataUtil
Generates dynamic emails.

---

## Execution

Run all tests:

```bash
mvn test
```

Run with specific browser:

```bash
mvn test -Dbrowser=chrome
```

---

## Configuration

`config.properties`

```properties
browser=chrome
url=https://automationexercise.com
timeout=10
```

---

## Reports

HTML Report:

```text
reports/cucumber-reports/cucumber.html
```

JSON Report:

```text
reports/cucumber-reports/cucumber.json
```

Logs:

```text
reports/logs/test.log
```

---

## Author

Deepthi  
SDET | Selenium | Java | Cucumber | Automation Testing
Feature: Login and Logout

  Scenario Outline: Login user with different Credentials
    Given I Verify the Home Page Logo on the Home Screen
    When I Click on Signup and Login on the Home Screen

     # Register only when needed
    When I prepare user setup for "<UserType>" with password "<Password>"

    Then I Verify the Login page Visible
    When I Enter Login Credentials with Password "<Password>"
    And I Click on Login
    Then I Verify "<Result>"

  Examples:
    |UserType   |Password   |Result                              |
    |Valid      |test123    |Logged in UserName is visible       |
    |Invalid    |test@123   |Your email or password is incorrect!|


  Scenario: Logout user successfully
     Given I Verify the Home Page Logo on the Home Screen
     When I Click on Signup and Login on the Home Screen

     When I prepare user setup for "Valid" with password "test123"

     Then I Verify the Login page Visible
     When I Enter Login Credentials with Password "test123"
     And I Click on Login

     Then I Verify the Logged in UserName on the Home Screen
     When I Click on the Logout
     Then I Verify the user is logged out on the Home Screen





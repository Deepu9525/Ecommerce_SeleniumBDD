Feature: User Registration

  Scenario: Register New User Successfully and Delete Account
    Given I Verify the Home Page Logo on the Home Screen
    When I Click on Signup and Login on the Home Screen

    Then I Verify the Signup form and heading on the Signup and Login Screen
    When I Enter valid Name and Email on the Signup and Login Screen
    And I Click on Signup

    Then I Verify the Enter Account Information on the Registration Screen
    When I Enter all Registration details on the Registration Screen
    And I Click on the Create Account on the Signup Login Screen

    Then I Verify the Account Created message on the Signup Login Screen
    And I Verify the Continue button is displayed on the Signup Login Screen
    When I Click on the Continue button

    Then I Verify the Logged in UserName on the Home Screen
    When I Click on the Delete Account on the Home Screen

    Then I Verify the Account Deleted message
    And I Verify the Continue button is displayed on the Signup Login Screen
    And I Click on the Continue button
    Then I Verify the user is logged out on the Home Screen


  Scenario: Register with existing email
    Given I Verify the Home Page Logo on the Home Screen
    When I Click on Signup and Login on the Home Screen
    Then I Verify the Signup form and heading on the Signup and Login Screen

    When I Enter valid Name and Email on the Signup and Login Screen
    And I Click on Signup
    When I Enter all Registration details on the Registration Screen
    And I Click on the Create Account on the Signup Login Screen
    And I Click on the Continue button
    And I Click on the Logout

    When I Click on Signup and Login on the Home Screen
    Then I Verify the Signup form and heading on the Signup and Login Screen
    When I Enter valid Name and already registered Email
    And I Click on Signup
    Then I Verify error message "Email Address already exist"




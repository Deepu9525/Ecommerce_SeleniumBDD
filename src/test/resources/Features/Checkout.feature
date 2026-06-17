Feature: Place Order
  Scenario: Place Order Register While Checkout
    Given I Verify the Home Page Logo on the Home Screen

    When I hover over 4 product and click Add to Cart
    And I Click on Continue Shopping button

    And I hover over 6 product and click Add to Cart
    And I Click on View Cart button

    Then I Verify that Cart Page is displayed

    When I Click on Proceed To Checkout button
    And I Click on Register and Login

    When I Enter valid Name and Email on the Signup and Login Screen
    And I Click on Signup
    When I Enter all Registration details on the Registration Screen
    And I Click on the Create Account on the Signup Login Screen
    Then I Verify the Account Created message on the Signup Login Screen
    And I Verify the Continue button is displayed on the Signup Login Screen

    When I Click on the Continue button
    Then I Verify the Logged in UserName on the Home Screen

    When I Click on Cart button
    And I Click on Proceed To Checkout button

    Then I Verify Address Details
    And I Verify Review your Order section

    When I Enter order comment
    And I Click on Place Order button

    And I Enter payment details
    When I Click on Pay and Confirm Order

    Then I Verify order placed successfully
    When I Click on the Delete Account
    Then I Verify the Account Deleted message

    And I Verify the Continue button is displayed on the Signup Login Screen
    And I Click on the Continue button
    Then I Verify the user is logged out on the Home Screen







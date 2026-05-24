Feature: Subscription
  Scenario: Verify Subscription in home page
    Given I Verify the Home Page Logo on the Home Screen

    When I Scroll down to footer
    Then I Verify text "SUBSCRIPTION"
    When I Enter subscription email "test12@gmail.com"
    And I Click on subscription arrow button
    Then I Verify success subscription message

    Scenario: Verify Subscription in Cart page
      Given I Verify the Home Page Logo on the Home Screen

      When I Click on Cart button
      And I Scroll down to footer
      Then I Verify text "SUBSCRIPTION"
      When I Enter subscription email "test12@gmail.com"
      When I Click on subscription arrow button
      Then I Verify success subscription message


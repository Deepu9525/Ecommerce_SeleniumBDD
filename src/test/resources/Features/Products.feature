Feature: Products Page
  Scenario: Verify all Products and product detail page
    Given I Verify the Home Page Logo on the Home Screen

    When I Click on Products button

    Then I Verify user is navigated to all Products page successfully
    And I Verify Products list is visible

    When I Click on View Product of product number 1
    Then I Verify user is navigated to Product detail page
    And I Verify Product name is visible
    And I Verify Category is visible
    And I Verify Price is visible
    And I Verify Availability is visible
    And I verify Condition is visible
    And I Verify Brand is visible

    Scenario Outline: Verify Search Product functionality
      Given I Verify the Home Page Logo on the Home Screen

      When I Click on Products button

      Then I Verify user is navigated to all Products page successfully
      When I Enter Product Name "<productName>" in search
      And I Click on search button
      Then I Verify search Products text is visible
      And I Verify all searched Products are related to "<productName>"

      Examples:
      |productName |
      |Blue Top    |
      |Top         |
      |Dress       |

      Scenario: Verify Add Products in Cart
        Given I Verify the Home Page Logo on the Home Screen

        When I Click on Products button

        And I hover over 1 product and click Add to Cart
        And I Click on Continue Shopping button

        And I hover over 2 product and click Add to Cart
        And I Click on View Cart button

        Then I Verify the both products are added to cart
        And I Verify their prices quantity and total price

      Scenario: Verify Product quantity in Cart
        Given I Verify the Home Page Logo on the Home Screen

        When I Click on View Product of product number 5
        Then I Verify user is navigated to Product detail page
        And I Verify Product name is visible
        And I Verify Category is visible
        And I Verify Price is visible
        And I Verify Availability is visible
        And I verify Condition is visible
        And I Verify Brand is visible

        And I Increase product quantity to "4"
        When I Click on Add to Cart button
        And I Click on View Cart button
        Then I Verify the product quantity is "4" in cart




















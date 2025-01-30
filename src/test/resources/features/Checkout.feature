Feature: Checkout Process on Swag Labs

  Background: User is logged in and on the products page
    Given I open the login page "https://www.saucedemo.com/"
    When I enter "standard_user" as username and "secret_sauce" as password

  Scenario: Checkout complete
    When I add an item to the cart
    And I go to the cart page
    And I proceed to checkout with first name "John", last name "Doe", and postal code "12345"
    Then I should see the checkout complete message

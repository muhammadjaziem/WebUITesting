Feature: Login Page Testing

  Background: User opens the login page
    Given I open the login page "https://www.saucedemo.com/"

  @ValidLogin
  Scenario: Login with valid credentials
    When I enter "standard_user" as username and "secret_sauce" as password
    Then I should be redirected to the products page

  @LockedOutLogin
  Scenario: Login with locked out user
    When I enter "locked_out_user" as username and "secret_sauce" as password
    Then I should see an error message "Sorry, this user has been locked out."

  @InvalidLogin
  Scenario: Login with incorrect password
    When I enter "standard_user" as username and "wrong_password" as password
    Then I should see an error message "Username and password do not match any user in this service"

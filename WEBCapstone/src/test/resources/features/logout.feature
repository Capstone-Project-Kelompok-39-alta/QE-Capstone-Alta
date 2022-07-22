@Logout
  Feature: Logout
    As a admin
   I want to logout from dashboard page
  So that I can logout from dashboard

  Scenario Outline: Logout Scenario
    Given I am on the login pages
    When I inputs "<nip>" nip
    And I inputs "<password>" password
    And clicks login button
    And I get to dashboard page
    And click profile button
    And click logout button
    Then I validate back to login page

    Examples:
      |nip|password|
    |23456789|admintesting|
@HistoryEmail
Feature: History Email
  As a admin
  I want to access history email that i send to user
  So that I can look success or not send to user


  Scenario Outline: History Email Scenario

    Given I am on the Login Pages
    When I input "<NIP>" NipS
    And I input "<Password>" PASSWORD
    And click Login Buttons
    And I get to Dashboard pages
    And click History Email Pages
    And click delete buttons
    Then I validate the "<Result>" results

    Examples:
      |NIP|Password|Result|
      | 23456789  | admintesting       |history page|
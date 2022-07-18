#@Invoice
#  Feature: Invoice
#  As a admin
#  I want to access invoice information
#  So that I can access information about invoice user
#
#
#  Scenario Outline: Invoice Scenario Detail
#
#    Given I am on the Login page
#    When I input "<NIP>" NIP
#    And I input "<Password>" Password
#    And click Login button
#    And I get to Dashboard page
#    And click Invoice Page
#    And click detail invoice button
#    Then I validate the "<Result>" Result
#
#    Examples:
#    |NIP|Password|Result|
#    | 23456789  | admintesting       |invoice page|
#
#    Scenario Outline: Invoice Scenario Send
#      Given I am on the Login pages
#      When I input "<NIP>" NIPs
#      And I input "<Password>" Passwords
#      And click Login buttons
#      And I get to Dashboard Pages
#      And click Invoice Pages
#      And click send invoice button
#      Then I validate the "<Result>" Results
#
#      Examples:
#      |NIP|Password|Result|
#      | 23456789  | admintesting       |invoice page|
#
#
#
#
#
#

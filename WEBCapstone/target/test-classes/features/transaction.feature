#@Transaction
#Feature: Transaction
#  As a admin
#  I want to access transaction information
#  So that I can access information about user transaction
#
#
#  Scenario Outline: Transaction Scenario Detail
#
#    Given I am on the Login Page
#    When I input "<NIP>" NIPS
#    And I input "<Password>" PassworD
#    And click Login Button
#    And I get to Dashboard Page
#    And click Transaction Page
#    And click detail transaction button
#    Then I validate the "<Result>" Resultt
#
#    Examples:
#      |NIP|Password|Result|
#      | 23456789  | admintesting       |transaction page|
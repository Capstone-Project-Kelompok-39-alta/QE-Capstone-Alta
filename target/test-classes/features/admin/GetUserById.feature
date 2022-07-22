@GetUserById
Feature: Get User
#  Scenario: As admin I want to
#    Given Admin set GET api endpoint for get user
#    When Admin send GET HTTP request for get user
#    Then Admin receive valid HTTP response code 200 for get user
#    And  Admin receive detail data for user

  Scenario: As admin I want to Get User By Id
    Given Admin success auth using new user
    When Admin set GET api endpoint for get user
    And Admin send GET HTTP request for get user
    Then Admin receive valid HTTP response code 200 for get user
    And Admin receive detail data for user

  Scenario: As admin I want to Get User By Id without login
    Given Admin set GET api endpoint for get user
    When Admin send GET HTTP request for get user wihout login
    Then Admin receive valid HTTP response code 400 for get user
    And Admin receive message invalid or expired jwt for get user
#
#  Scenario: As admin I want to Get User By unregistered Id
#    Given Admin success auth using new user
#    When Admin set GET api endpoint for get user
#    And Admin send GET HTTP request for get user
#    Then Admin receive valid HTTP response code 200 for get user
#    And Admin receive detail data for user
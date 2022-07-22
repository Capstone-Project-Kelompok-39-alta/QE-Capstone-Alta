@Register
Feature: Register

  Background:
    Given Admin set POST api endpoint for register

#  Scenario Outline: As Admin I have be able to create new user
#    Given Admin set POST api endpoint for register
#    When Admin send "<email>" POST HTTP request for register
#    Then Admin receive valid HTTP response code 201
#    And Admin receive valid data for new user
#
#  Examples:
#  |email|id_pegawai|name|password|
#  |sautkristianwiratamamanurung|23456789|sautkristianwiratamamanurung|admintesting|


  Scenario: As Admin I have be able to create new user with valid data

    When Admin send POST HTTP request for register
    Then Admin receive valid HTTP response code 201
    And Admin receive valid data for new user

  Scenario: As Admin I to create new user with registered data
    When Admin send POST HTTP request for register
    Then Admin receive valid HTTP response code 406
    And Admin receive message User exists

  Scenario: As Admin I have to create new user with null data
    When Admin send POST HTTP request for register with null data
    Then Admin receive invalid HTTP response code 500 for register
    And Admin receive message Internal Server Error for register




#  Scenario: As Admin I have be able to create new user with valid data
#    Given Admin set POST api endpoint for register
#    When Admin send POST HTTP request for register
#    Then Admin receive valid HTTP response code 201
#    And Admin receive valid data for new user






@Login
Feature: Login

#  Background:
#    Given Admin set POST api endpoint for login

  Scenario: POST - As admin I want to login with valid idpegawai and password
    Given Admin set POST api endpoint for login
    When Admin send POST HTTP request for login
    Then Admin receive valid HTTP response code 200 for login
    And  Admin receive token and message

  Scenario: As admin I want to login with valid idpegawai and invalid password

    When Admin send POST HTTP request for invalid password
    Then Admin receive invalid HTTP response code 401 for login
    And  Admin receive message

  Scenario: As As admin I want to login with invalid idpegawai and valid password

    When Admin send POST HTTP request for invalid idpegawai
    Then Admin receive invalid HTTP response code 401 for login
    And  Admin receive message

  Scenario: As admin I want to login with null idpegawai and password
    When Admin send POST HTTP request for null idpegawai and password
    Then Admin receive invalid HTTP response code 400
    And  Admin receive message bad request

  Scenario: As admin I want to login with unregistered data
    When Admin send POST HTTP request for login with unregistered data
    Then Admin receive invalid HTTP response code 401 for login
    And  Admin receive message bad request

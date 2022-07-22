Feature: Invoice
#  Scenario: As Admin I want to upload file csv for Invoice
#    Given Admin set GET api endpoint for Invoice
#    When Admin send GET HTTP request for Invoice
#    Then Admin receive valid HTTP response code 201 for Invoice
#    And Admin receive valid data for detail invoice

  @UploadCsv
  Scenario: As Admin I want to upload file csv for Invoice
    Given Admin success auth using new user for Invoice
    When Admin set POST api endpoint for Invoice
    And Admin send POST HTTP request for Invoice
    Then Admin receive valid HTTP response code 201 for Invoice
    And Admin receive detail Invoice

  @GetAllInvoice
  Scenario: As admin I want to Get All Invoice
    Given Admin success auth using new user for Get All Invoice
    When Admin set GET api endpoint for Get All Invoice
    And Admin send GET HTTP request for Get All Invoice
    Then Admin receive valid HTTP response code 200 for Get All Invoice
    And Admin receive detail All Invoice


  @GetInvoiceById
  Scenario: As admin I want to Get Invoice by Id
    Given Admin success auth using new user for Get Invoice by Id
    When Admin set GET api endpoint for Get Invoice by Id
    And Admin send GET HTTP request for Get Invoice by Id
    Then Admin receive valid HTTP response code 200 for Get Invoice by Id
    And Admin receive detail Invoice by Id


   Scenario: As Admin I want to get All Invoice without login
    Given Admin set GET api endpoint for Get All Invoice
    When Admin send GET HTTP request for Get All Invoice without login
    Then Admin receive invalid HTTP response code 400 for Invoice
    And Admin receive message invalid or expired jwt

  Scenario: As Admin I want to get Invoice By Id without login
    Given Admin set GET api endpoint for Get Invoice by Id
    When Admin send GET HTTP request for Get Invoice by Id without login
    Then Admin receive invalid HTTP response code 400 for Invoice
    And Admin receive message invalid or expired jwt

  Scenario: As Admin I want to Upload CSV without login
    Given Admin set POST api endpoint for Invoice
    When Admin send POST HTTP request for Invoice without login
    Then Admin receive invalid HTTP response code 400 for Invoice
    And Admin receive message invalid or expired jwt

  Scenario: As Admin I want to Upload CSV without send file csv
    Given Admin set GET api endpoint for Get All Invoice
    When Admin send GET HTTP request for Get All Invoice without send file csv
    Then Admin receive invalid HTTP response code 500 for Invoice
    And Admin receive message Internal Server Error

  Scenario: As Admin I want to Upload CSV with different extensions
    Given Admin success auth using new user for Invoice
    When Admin set POST api endpoint for Invoice
    And Admin send POST HTTP request for Invoice with different extensions
    Then Admin receive valid HTTP response code 400 for Invoice with different extensions
    And Admin receive message invalid extension file

#  Scenario: As Admin I want to get detail Invoice By Id
#    Given Admin set GET api endpoint for Invoice By Id
#    When Admin send GET HTTP request for Invoice By Id
#    Then Admin receive valid HTTP response code 200
#    And Admin receive valid data for detail Invoice By Id

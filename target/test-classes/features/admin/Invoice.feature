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





#   Scenario: As Admin I want to get Invoice
#    Given Admin set GET api endpoint for Invoice
#    When Admin send GET HTTP request for Invoice
#    Then Admin receive valid HTTP response code 201
#    And Admin receive valid data for detail invoice

#  Scenario: As Admin I want to get detail Invoice By Id
#    Given Admin set GET api endpoint for Invoice By Id
#    When Admin send GET HTTP request for Invoice By Id
#    Then Admin receive valid HTTP response code 200
#    And Admin receive valid data for detail Invoice By Id

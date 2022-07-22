Feature: Send Email Customer

  @SendEmail
  Scenario: As admin I want to send Email to Customer
    Given Admin success auth using new user for send email
    When Admin set POST api endpoint for send email
    And Admin send POST HTTP request for send email
    Then Admin receive valid HTTP response code 201 for send email
    And Admin receive detail for send email
#
#  Scenario: As admin I want to send Email to unregistered email
#    Given Admin success auth using new user for send email
#    When Admin set POST api endpoint for send email
#    And Admin send POST HTTP request for send email
#    Then Admin receive valid HTTP response code 400 for send email
#    And Admin receive detail for send email


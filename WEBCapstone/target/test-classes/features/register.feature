#@Register
#
#  Feature: Register
#    As a admin
#  I want to create new admin account
#  So that I can create new admin account
#
#  Scenario Outline: Register Scenario
#    Given I am on the register page
#    When I input "<namalengkap>" namalengkap
#    And I input "<nips>" nips
#    And I input "<emails>" emails
#    And I input "<passwords>" passwords
#    And click register button
#    Then I get the "<results>" results
#
#    Examples:
#    |namalengkap|nips|emails|passwords|results|
##    |imamrayhanekadinata|1233212244|imamrayhane@gmail.com|rayhangantenk|login page|
#    |                   |          |                     |             |register page|

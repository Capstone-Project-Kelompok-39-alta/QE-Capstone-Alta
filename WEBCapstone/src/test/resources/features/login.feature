@Login
  Feature: Login
    As a admin
  I want to login to dashboard page
  So that I can access dashboard


  Scenario Outline:Login Scenario
  Given I am on the login page
  When I input "<nip>" nip
  And I input "<password>" password
  And click login button
   Then I get the "<result>" result

    Examples:
  |nip|password|result|
    |23456789   |admintesting|  dashboard page|
    |           |            |   login page   |
@Login
Feature: Login

  @Positive
  Scenario Outline: Login test with valid credentials
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    Then I should see the "<expectedResult>"

    Examples:
    | email | password | expectedResult |
    | admin@hadir.com | MagangSQA_JC@123 | Dashboard Menu |
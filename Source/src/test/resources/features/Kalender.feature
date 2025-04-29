@Kalender
Feature: Kalender

  Background:
    Given I am on the login page
    When I enter email "admin@hadir.com" and password "MagangSQA_JC@123"
    And I click the login button
    Then I should see the "Dashboard Menu"

  @Positive
  Scenario Outline: Successfully adding kalender with valid data
    Given I am on the kalender page
    When I input kalender data with kalender unit "<kalenderUnit>"
    And I click the add button kalender

    Examples:
      | kalenderUnit     |
      | Kalender Unit 1  |
      | Kalender Unit 2  |

  @Positive
  Scenario Outline: Successfully searching kalender data after adding
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    Then I should see a row "<expectedResult>"

    Examples:
    | name            | expectedResult  |
    | Kalender Unit 1 | Kalender Unit 1 |
    | Kalender Unit 2 | Kalender Unit 2 |
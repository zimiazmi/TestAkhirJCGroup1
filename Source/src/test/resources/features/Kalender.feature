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
  Scenario Outline: Successfully searching kalender after adding
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    Then I should see a row "<expectedResult>"

    Examples:
    | name            | expectedResult  |
    | Kalender Unit 1 | Kalender Unit 1 |
    | Kalender Unit 2 | Kalender Unit 2 |

  @Positive
  Scenario Outline: Successfully edit kalender
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    And I edit kalender unit to "<newKalenderUnit>"

    Examples:
      | name            | newKalenderUnit        |
      | Kalender Unit 1 | Kalender Unit 1 Edited |

  @Positive
  Scenario Outline: Successfully delete kalender
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    Then I delete kalender data

    Examples:
      | name            |
      | Kalender Unit 2 |

  @Positive
  Scenario Outline: Successfully view kalender
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    And I view kalender data
    Then I should see detail data kalender with tanggal "<tanggal>", tipe "<tipe>", deskripsi "<deskripsi>"

    Examples:
      | name               | tanggal     | tipe         | deskripsi     |
      | Libur Cuti Bersama | 28 Sep 2024 | Cuti Bersama | Libur Lebaran |
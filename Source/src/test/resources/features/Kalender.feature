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

    When I enter "<kalenderUnit>" in search column kalender
    And I click the search button kalender
    Then I should see a row "<kalenderUnit>"

    And I view kalender data
    And I input detail data kalender to tanggal "<tanggal>", tipe "<tipe>", deskripsi "<deskripsi>"
    Then I should see detail data kalender with:
      | Tanggal   | Tipe   | Deskripsi   |
      | <tanggal> | <tipe> | <deskripsi> |

    Examples:
      | kalenderUnit    | tanggal    | tipe           | deskripsi           |
      | Kalender Unit 1 | 09/29/2024 | Libur Nasional | Libur Lebaran Add 1 |
      | Kalender Unit 2 | 09/29/2024 | Cuti Bersama   | Libur Lebaran Add 2 |

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

    Given I reload the page
    When I enter "<newKalenderUnit>" in search column kalender
    And I click the search button kalender
    Then I should see a row "<newKalenderUnit>"

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
  Scenario Outline: Successfully edit and view detail kalender
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    And I view kalender data
    And I edit detail data kalender to newTanggal "<newTanggal>", newTipe "<newTipe>", newDeskripsi "<newDeskripsi>"
    Then I should see detail data kalender with:
    | Tanggal      | Tipe      | Deskripsi      |
    | <newTanggal> | <newTipe> | <newDeskripsi> |

    Examples:
      | name               | newTanggal | newTipe        | newDeskripsi           |
      | Libur Cuti Bersama | 09/29/2024 | Libur Nasional | Libur Lebaran Edited 2 |

  @Negative
  Scenario Outline: Add kalender without kalender unit name
    Given I am on the kalender page
    When I input kalender data with kalender unit "<kalenderUnit>"
    And I click the add button kalender
    Then I should see error message "<expectedMessage>"

    Examples:
      | kalenderUnit     | expectedMessage                |
      |                  | Nama kalender unit harus diini |

  @Negative
  Scenario Outline: Searching invalid data
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    Then I should see a empty row

    Examples:
      | name                  |
      | Kalender Unit Invalid |

  @Negative
  Scenario Outline: Edit kalender with blank name
    Given I am on the kalender page
    When I enter "<name>" in search column kalender
    And I click the search button kalender
    And I edit kalender unit to "<newKalenderUnit>"
    Then I should see error message "<expectedMessage>"

    Examples:
      | name            | newKalenderUnit | expectedMessage                |
      | Kalender Unit 1 |                 | Nama kalender unit harus diini |
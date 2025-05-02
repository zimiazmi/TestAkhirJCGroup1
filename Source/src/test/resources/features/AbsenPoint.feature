@AbsenPoint
  Feature: Absen Point

    Background:
      Given I am on the login page
      When I enter email "admin@hadir.com" and password "MagangSQA_JC@123"
      And I click the login button
      Then I should see the "Dashboard Menu"

    @Positive
    Scenario Outline: Successfully adding absen point with valid data
      Given I am on the absen point page
      When I input location point data with name "<name>" , latitude <latitude> , longitude <longitude> , radius <radius> , description "<description>"
      And I click the add button

      Examples:
       | name        | latitude  | longitude  | radius | description|
       | AbsenPoint1 | -6.240723 | 106.835780 | 100    | test1      |
       | AbsenPoint2 | -6.240723 | 106.835780 | 110    | test2      |

    @Positive
    Scenario Outline: Successfully searching absen point data after adding
      Given I am on the absen point page
      When I enter "<name>" in search column
      And I click the search button
      Then I should see a row with:
        | Name    | Latitude   | Longitude  | Radius   | Description   |
        | <name>  | <latitude> |<longitude> | <radius> | <description> |

      Examples:
        | name        | latitude  | longitude  | radius | description|
        | AbsenPoint1 | -6.240723 | 106.835780 | 100    | test1      |
        | AbsenPoint2 | -6.240723 | 106.835780 | 110    | test2      |

    @Positive
    Scenario Outline: Successfully edit existing absen point data
      Given I am on the absen point page
      When I enter "<name>" in search column
      And I click the search button
      And I update absen point data to:
        | Name      | Latitude      | Longitude      | Radius      | Description      |
        | <newName> | <newLatitude> | <newLongitude> | <newRadius> | <newDescription> |

      Given I reload the page
      When I enter "<newName>" in search column
      And I click the search button
      Then I should see a row with:
        | Name    | Latitude   | Longitude  | Radius   | Description   |
        | <newName>  | <newLatitude> |<newLongitude> | <newRadius> | <newDescription> |

      Examples:
        | name        | newName            | newLatitude | newLongitude | newRadius | newDescription |
        | AbsenPoint1 | AbsenPoint1Update  | -6.123456   | 106.123456   | 120       | updated1       |

    @Positive
    Scenario Outline: Successfully delete existing absen point data
      Given I am on the absen point page
      When I enter "<name>" in search column
      And I click the search button
      Then I delete absen point data

      Examples:
        | name        |
        | AbsenPoint2 |

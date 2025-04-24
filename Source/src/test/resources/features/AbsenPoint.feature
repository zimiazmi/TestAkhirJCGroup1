@AbsenPoint
  Feature: Absen Point

    @Positive
    Scenario Outline: Add absen point with valid data
      Given I am on the login page
      When I enter email "<email>" and password "<password>"
      And I click the login button
      Given I am on the absen point page
      When I input location point data with name "<name>" , latitude <latitude> , longitude <longitude> , radius <radius> , description "<description>"
      And I click the add button

      Examples:
      | email | password | name | latitude | longitude | radius | description|
      | admin@hadir.com | MagangSQA_JC@123 | testRio | -6.240723 | 106.835780 | 100 | test |
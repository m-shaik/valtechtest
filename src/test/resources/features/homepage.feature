@test
Feature: Valtech - Home Page Tests

Scenario:Latest News Section is displayed
  Given I navigate to valtech home page
  Then Latest news section is displayed

Scenario Outline: Verify that page titles are correct
  Given I navigate to valtech home page
  When Click on page link <pageLink>
  Then page title shows correct title
Examples:
  |pageLink |
  | About   |
  | Works   |
  | Services |


  Scenario: number of contact offices
    Given I navigate to valtech contact us page
    Then the number of offices are shown




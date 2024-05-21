Feature: Use the job search functionality

  Background:
    Given I am on the cookie clicker homepage
    And I choose a random name

  Scenario: Clicking a cookie adds a cookie
    Given I start a new game
    And I click a cookie
    Then my cookie count should be 1
    And my factory count should be 0
    And my money total should be 0

  Scenario: Buying a factory should cost $3
    Given I start a new game
    And I click 13 cookies
    And I sell 12 cookies
    And my money total should be 3
    When I buy 1 factory
    Then my cookie count should be 1
    And my factory count should be 1
    And my money total should be 0
    And the cookie count goes up 1 per second

  Scenario: Buying multiple factories should increase the cookie count
    Given I start a new game
    And I click 25 cookies
    And I sell 24 cookies
    When I buy 2 factories
    Then my factory count should be 2
    And the cookie count goes up 2 per second
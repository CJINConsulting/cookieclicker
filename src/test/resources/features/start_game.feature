Feature: Use the job search functionality

  Background:
    Given I am on the cookie clicker homepage

  Scenario: New games start at zero
    Given I choose the name "Timothy"
    And I start a new game
    Then the game shows a welcome message including the player's name
    And the game values are set to zero

  Scenario: Player names have spaces trimmed
    Given I choose the name " John "
    And I start a new game
    Then the game shows a welcome message including the name "Hello John"

  Scenario Outline: New players can set a name value of their choice
    Given I choose the name "<player_name>"
    And I start a new game
    Then the game shows a welcome message including the player's name

    Examples:
      | player_name                            |
      | a                                      |
      | Joh\"`\\,;:&<>^*?!$%^&*()-_=+[]{}@~#.? |
      | Joh n                                  |
      | john                                   |
      | JOHN                                   |
      | James Anthony                          |
      | Miles Cholmondeley-Warner              |
      | CPP                                    |

  Scenario Outline: New players can set a name length of their choice
    Given I set the name to <name_length> characters long
    And I start a new game
    Then the game shows a welcome message including the player's name

    Examples:
      | name_length |
      | 256         |
      | 257         |
      | 1000        |
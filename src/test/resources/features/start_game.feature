Feature: Pre-game user behaviour

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

  Scenario: Existing games maintain your progress
    Given I choose a random name
    And I start a new game
    And I click 10 cookies
    And I sell 4 cookies
    And I go back to the homepage
    When I select my existing game from the high score table
    Then my cookie count should be 6
    And my money total should be 1
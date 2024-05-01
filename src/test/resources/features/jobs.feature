Feature: Use the job search functionality

  Background:
    Given the user is on the lexisnexus homepage

  Scenario: Search all jobs and find results
    Given the About Us menu is selected
    And the Careers menu option is selected
    When the browser is switched to the Careers tab
    And the user selects Search all jobs
    Then a list of jobs is shown on the page

Feature: As a user, I should be able to access to Files module - Favorites button
  Scenario: Verify users to add files to Favorites
    Given user on the dashboard page
    When  user clicks the "Files" module
    When  user clicks action-icon from any file on the page
    And user chooses the "Add to favorites" option
    And user clicks the "Favorites" sub-module on the left side
    Then user verifies the chosen file is listed on the table
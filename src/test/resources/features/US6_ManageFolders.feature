Feature: As a user, I should be able to remove files from the favorites and upload a file directly
  Background:
    Given user on the dashboard page
    When  user clicks the "Files" module
  Scenario: Verify users can add the folder
    When  user clicks action-icon from any file on the page
    And user chooses the "Remove from favorites" option
    And user clicks the "Favorites" sub-module on the left side
    Then user verifies that the file is removed from the "Favorites" sub-module’s table

  Scenario: Verify users can upload a file inside a folder
    And user chooses a folder from the page
    And user clicks the add icon on the top
    When user uploads a file with the "Upload file" option
    Then verifies the file is displayed on the page
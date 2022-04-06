Feature: As a user, I should be able to remove files from favorites and upload a file directly
  Background:
    Given user on the dashboard page
    When user clicks the "Files" module
  Scenario: verify users to remove files to Favorites
    When user clicks action-icon from any file on the page
    And user chooses the "Remove from favorites" option
    And user clicks the "Favorites" sub-module on the left side
    Then verifies that the file is removed from the Favorites sub-module’s table

  Scenario: verifies users to upload a file from Files
    When  user clicks the add icon on the top
    And  user uploads file with the "Upload file" option
    Then verifies the file is displayed on the page
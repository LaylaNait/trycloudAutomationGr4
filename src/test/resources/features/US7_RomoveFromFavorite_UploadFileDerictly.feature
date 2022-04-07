Feature: As a user, I should be able to remove files from favorites and upload a file directly
  Background:
    Given user on the dashboard page
    When user clicks the "Files" module
  Scenario: Verify users can add the folder
   And  user clicks the add icon on the top
    And user clicks "new folder"
    And user write a folder name
    When user clicks submit icon
    Then verifies the folder is displayed on the page

  Scenario: verify users can upload a file inside a folder
    And user chooses a folder from the page
    And user clicks the add icon on the top
    When  user uploads a file with the upload file option
    Then verifies the file is displayed on the page
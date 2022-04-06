Feature: As a user, I should be able to write comments to files/folders.
  Scenario: Verify users to write comments to files/folder
    Given user on the dashboard page
    When  user clicks the "Files" module
    When user clicks action-icon from any file on the page
    And user chooses the "Details" option
    And user clicks the "comments" option
    And user writes a "comment" inside the input box
    And user clicks the submit button to post it
    Then verifies the "comment" is displayed in the comment section.
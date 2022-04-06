Feature: As a user, I should be able to delete a file/folder.
  Scenario: Verify users delete a file/folder
    Given user on the dashboard page
    When the user clicks the "Files" module
    And user clicks action-icon from any file on the page
    And user chooses the "Delete f" option
    When user clicks the "Deleted f" sub-module on the left side
    Then verifies the deleted file is displayed on the page
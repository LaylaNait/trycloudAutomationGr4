Feature: As a user, I should be able to delete a file/folder.
  @test1
  Scenario Outline: Verify users delete a file/folder
    Given user on the dashboard page with "<username>" and "<password>"
    When the user clicks the "Files" module
    And user clicks action-icon from any file on the page
    And user chooses the "Delete f" option
    When user clicks the "Deleted f" sub-module on the left side
    Then verifies the deleted file is displayed on the page
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
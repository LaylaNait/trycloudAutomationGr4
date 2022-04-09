Feature: As a user, I should be able to write comments to files/folders.
  Scenario Outline: Verify users to write comments to files/folder
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Files" module
    When user clicks action-icon from any file on the page
    And user chooses the "Details" option
    And user clicks the comments option
    And user writes a "Hello, Bye now" inside the input box
    And user clicks the submit button to post it
    Then verifies the "Hello, Bye now" is displayed in the comment section
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
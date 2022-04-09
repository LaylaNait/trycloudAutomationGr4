Feature: As a user, I should be able to remove files from the favorites and upload a file directly

  Scenario Outline: Verify users to remove files to Favorites
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Files" module
    When  user clicks action-icon from any file on the page to remove
    And user chooses the "Remove from favorites" option
    And user clicks the "Favorites" sub-module on the left side
    Then user verifies that the file is removed from the "Favorites" sub-module’s table
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

  Scenario Outline: verifies users to upload a file from Files
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Files" module
    When user clicks the add icon on the top
    When user uploads a file with the upload file option
    Then verifies the file is displayed on the page
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
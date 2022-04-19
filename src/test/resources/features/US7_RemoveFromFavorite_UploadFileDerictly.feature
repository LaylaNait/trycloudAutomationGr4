Feature: As a user, I should be able to remove files from favorites and upload a file directly
@test7
  Scenario Outline: Verify users can add the folder
    Given user on the dashboard page with "<username>" and "<password>"
    When user clicks the "Files" module
  When user clicks the add icon on the top
    And user clicks "new folder"
    And user write a folder name
    When user clicks submit icon
    Then verifies the folder is displayed on the page
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

  Scenario Outline: verify users can upload a file inside a folder
    Given user on the dashboard page with "<username>" and "<password>"
    When user clicks the "Files" module
    And user chooses a folder from the page
    When  user uploads a file with the upload file option
    Then verifies the file is displayed on the page
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
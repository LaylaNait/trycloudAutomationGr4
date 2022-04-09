Feature:As a user, I should be able to update settings.

Scenario Outline: Verify users update settings
  Given user on the dashboard page with "<username>" and "<password>"
  When  user clicks the "Files" module
And user clicks "Settings" on the left bottom corner
Then user should be able to click any buttons
  Examples:
    | username | password |
    | user4    | Userpass123 |
    | user34   | Userpass123 |
    | user64   | Userpass123 |
    | user94   | Userpass123 |

Scenario Outline: Verify users to see the app storage usage
  Given user on the dashboard page with "<username>" and "<password>"
  When  user clicks the "Files" module
And user checks the current storage usage
And user uploads file with the "Upload file" option
And user refreshes the page
Then  user should be able to see storage usage is increased
  Examples:
    | username | password |
    | user4    | Userpass123 |
    | user34   | Userpass123 |
    | user64   | Userpass123 |
    | user94   | Userpass123 |
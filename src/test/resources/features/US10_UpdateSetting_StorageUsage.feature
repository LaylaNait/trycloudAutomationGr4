Feature:As a user, I should be able to update settings.
  Background:
    Given user on the dashboard page
    When  user clicks the "Files" module
Scenario: Verify users update settings
And user clicks "Settings" on the left bottom corner
Then user should be able to click any buttons

Scenario: Verify users to see the app storage usage
And user checks the current storage usage
And user uploads file with the "Upload file" option
And user refreshes the page
Then  user should be able to see storage usage is increased
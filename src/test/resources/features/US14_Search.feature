Feature: As a user, I should be able to search any item/ users from the homepage.
  Scenario: Verify users can search any files/folder/users from the search box.
    Given user on the dashboard page
    When  user clicks the magnifier icon on the right top
    And user searches any existing "file/folder/user" name
    Then verifies the app displays expected "file/folder/user" option

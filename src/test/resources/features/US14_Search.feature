Feature: As a user, I should be able to search any item/ users from the homepage.
  Scenario Outline: Verify users can search any files/folder/users from the search box.
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the magnifier icon on the right top
    And user searches any existing "file/folder/user" name
    Then verifies the app displays expected "file/folder/user" option
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

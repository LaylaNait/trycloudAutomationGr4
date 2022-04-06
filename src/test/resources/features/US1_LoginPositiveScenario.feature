
Feature: As a user, I should be able to log in.
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and passcode "<password>" and user click on the login button
    Then verify the user should be at the "<title>" page
    And user logout
    Examples:
      | username | password    | title     |
      | user4    | Userpass123 | Dashboard |
      | user34   | Userpass123 | Dashboard |
      | user64   | Userpass123 | Dashboard |
      | user94   | Userpass123 | Dashboard |

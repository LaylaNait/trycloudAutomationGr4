@wip
Feature: As a user, I should be able to log in.

  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and passcode "<password>" and user click on the login button
    Then verify the user should be at the "<title>" page
    Examples:
      | username | password    | title     |
      | user7    | Userpass123 | Dashboard |
      | user34   | Userpass123 | Dashboard |
      | user99   | Userpass123 | Dashboard |
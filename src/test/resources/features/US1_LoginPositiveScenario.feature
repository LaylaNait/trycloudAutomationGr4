@test1
Feature: As a user, I should be able to log in.
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and passcode "<password>" and user click on the login button
    Then verify title is "Dashboard - Trycloud QA"
    And user logout
    Examples:
      | username | password    |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

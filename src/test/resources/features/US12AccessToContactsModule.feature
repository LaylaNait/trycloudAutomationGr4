Feature: As a user, I should be able to access to Contacts module.
  Scenario Outline: verify user access to Talks module
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud QA"
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
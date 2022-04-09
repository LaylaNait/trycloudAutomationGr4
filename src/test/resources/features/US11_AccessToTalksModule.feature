Feature: As a user, I should be able to access to Talks module

  Scenario Outline: verify users to access to Talks module
    Given user on the dashboard page with "<username>" and "<password>"
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud"
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

  Scenario Outline: verify users to send a message
    Given user on the dashboard page with "<username>" and "<password>"
    When the user clicks the "Talk" module
    And user searches "User20" from the search box
    And user writes a message "message"
    And user clicks to submit button
    Then user should be able to see the "message" is displayed on the conversation log
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
Feature: As a user, I should be able to access to Talks module

  Scenario Outline: verify users to access to Talks module
    Given user on the dashboard page with "<username>" and "<password>"
    When user clicks the "Talk" module
    Then verify title is "Talk - Trycloud QA"

    Examples:
      | username | password    |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

  Scenario Outline: verify users to send a message
    Given user on the dashboard page with "<username>" and "<password>"
    When user clicks the "Talk" module
    And user searches "<user>" from the search box
    And user writes a message "message"
    And user clicks to submit button
    Then user should be able to see the "message" is displayed on the conversation log
    Examples:
      | username | password    | user    |
      | user4    | Userpass123 | User20  |
      | user34   | Userpass123 | User94  |
      | user64   | Userpass123 | User101 |
      | user94   | Userpass123 | User4  |
Feature: As a user, I should be able to access to Talks module
  Background:
    Given user on the dashboard page
    When the user clicks the "Talk" module
  Scenario: verify users to access to Talks module
    Then verify the page title is "Talk - Trycloud"

  Scenario: verify users to send a message
    And user searches "User20" from the search box
    And user writes a message "message"
    And user clicks to submit button
    Then user should be able to see the "message" is displayed on the conversation log
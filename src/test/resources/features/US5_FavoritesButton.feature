@wip
Feature: As a user, I should be able to access to Files module - Favorites button
  Scenario Outline: Verify users to add files to Favorites
    Given user on the dashboard page with "<username>" and "<password>"
    When the user clicks the Files module
    When the user clicks action-icon from any file on the page and user choose the Add to favorites option

    And user click the Favorites sub-module on the left side
    Then Verify the chosen file is listed on the table
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
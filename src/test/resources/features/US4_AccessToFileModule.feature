Feature: As a user, I should be able to access to Files module.
  Scenario Outline: verify users can access to Files module
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Files" module
    Then verify title is "Files - Trycloud QA"
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |

  Scenario Outline: verify users can select all the uploaded files from the page
    Given user on the dashboard page with "<username>" and "<password>"
    When  user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected
    Examples:
      | username | password |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
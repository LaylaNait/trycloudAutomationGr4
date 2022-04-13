@smoke
Feature: As a user, I should be accessing all the main modules of the app.
  @test1
  Scenario Outline: Verify users accessing all the main modules of the app.
    Given user on the login page
    When user use username "<username>" and passcode "<password>" and user click on the login button
    Then Verify the user see the following modules:
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

    And close browser

    Examples:
      | username | password    |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
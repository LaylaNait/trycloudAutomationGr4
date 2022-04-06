Feature: As a user, I should be accessing all the main modules of the app.
  Scenario: Verify users accessing all the main modules of the app.
    Given user on the login page "env"
    When user uses username "<username>" and passcode "<password>" and clicks login button
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
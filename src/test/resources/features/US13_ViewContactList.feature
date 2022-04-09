Feature: As a user, I should be able to view the contact list.
#Pre-condition: there should be at least 2 contact names are displayed
# On the contact list so that view list function can be tested a
  Scenario Outline: verify users can see all the contact names on the contact list
    Given user on the dashboard page with "<username>" and "<password>"
    When user clicks the "Contacts" module
    Then user verifies there are at least 2 contact names in the list
    Examples:
      | username | password    |
      | user4    | Userpass123 |
      | user34   | Userpass123 |
      | user64   | Userpass123 |
      | user94   | Userpass123 |
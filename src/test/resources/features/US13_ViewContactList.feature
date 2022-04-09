Feature: As a user, I should be able to view the contact list.
#Pre-condition: there should be at least 2 contact names are displayed
# On the contact list so that view list function can be tested
Scenario: verify users can see all the contact names on the contact list
Given user on the dashboard page
When user clicks the "Contacts" module
Then user verifies there are at least 2 contact names in the list
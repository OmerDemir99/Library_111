Feature: Login feature
  User Story: As a user, I should be able to login as librarian.


  @columns
  Scenario: User should be able to login as a librarian
    Given user is on the login page
    When user enters librarian "librarian4@library", "3lwxJ1Kk" and logins
    And user click "Users" link
    Then User should see table which has below columns
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |
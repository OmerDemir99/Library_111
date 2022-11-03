Feature: Login feature
  User Story: As a user, I should be able to login with valid credentials
  Student and librarian

  Background: User is expected to be on login page
    Given user is on the login page

  @student
  Scenario: User should be ble to login as a student
    When user enter student username
    And user enter student password
    And user click sign in button
    Then user should be able to see the student dashboard


 @librarian
  Scenario: User should be ble to login as a librarian
    When user enter  librarian username
    And user enter librarian password
    And user click sign in button
    Then user should be able to see the librarian dashboard
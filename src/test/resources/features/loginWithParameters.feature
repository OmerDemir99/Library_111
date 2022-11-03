Feature: Library app login feature with parameters with different roles

  User Story: As a user, I should be able to login with correct
  credentials to different accounts

  Background: User is expected to be on login page
    Given user is on the login page


  Scenario: User should be ble to login as a student
    When user enter student username "student8@library"
    And user enter student password "1DaJSz1z"
    And user click sign in button
    Then user should be able to see the student dashboard


  Scenario: User should be ble to login as a librarian
    When user enter librarian username "librarian4@library"
    And user enter librarian password "3lwxJ1Kk"
    And user click sign in button
    Then user should be able to see the librarian dashboard

  @wip
    Scenario: Login as librarian in the same line
      When user enters librarian username, password and logins
      Then user should be able to see the librarian dashboard


  Scenario: User should be ble to login
    When user enters below credentials and click sign in button

      | username | student2@library |
      | password | zyxa10vg         |

    Then user should be able to see the student dashboard




  Scenario: User should be able to login with valid credentials as a librarian
    When user enters librarian username, password and logins
    And user click sign in button
    Then librarian should be able see "1239" users
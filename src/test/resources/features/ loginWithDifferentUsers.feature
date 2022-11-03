Feature: Login feature

  User Story: As a user, I should be able to login with correct
  credentials to different accounts

  Background: User is expected to be on login page
    Given user is on the login page

    @user
    Scenario Outline: Login with different users
      When user enters librarian "<username>", "<password>" and logins
      Then user should be able to see username in the "<account username>" section

      @librarians
      Examples:different user credentials
        | username            | password | account username  |
        | librarian56@library | pBQnq0NN | Test Librarian 56 |
        | librarian57@library | SHzFWv8X | Test Librarian 57 |
        | librarian58@library | gxiYGKjy | Test Librarian 58 |
        | librarian59@library | DmSqxDEJ | Test Librarian 59 |
        | librarian60@library | Lj5VU4Tq | Test Librarian 60 |


      @students
      Examples: different student users

        | username         | password | account username |
        | student1@library | d5fv9BtX | Test Student 1   |
        | student2@library | zyxa10vg | Test Student 1   |
        | student3@library | rPjgZ86a | Test Student 1   |
        | student4@library | pG3V6qaL | Test Student 1   |
        | student5@library | i1oDgf2d | Test Student 1   |








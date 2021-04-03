Feature: Mailchimp test
  In order to sign up different users i want everything to run smooth.

  @mytag

  Scenario Outline: sign up

    Given I have entered my "<email>"
    Given I have also entered a "<username>"
    And I have also selected a "<password>"
    When I press sign up
    Then the "<result>" should be on the screen for "<username>"
    Examples:
      | email  | username  | password              | result                                                                             |
      | email1 | rand      | Alltgarsomdeska23!    | Check your email                                                                   |
      | email1 | longName  | hejHejhje1234!        | Enter a value less than 100 characters long                                        |
      | email1 | existing  | Alltgarsomdeska23!    | Another user with this username already exists. Maybe it's your evil twin. Spooky. |
      |        | randAgain | ingetGarsomdetska123! | Please enter a value                                                               |
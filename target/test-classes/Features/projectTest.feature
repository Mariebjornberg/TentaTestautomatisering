Feature: Mailchimp test
  In order to sign up different users i want everything to run smooth.

  @mytag

  Scenario Outline: sign up
    Given I have entered my "<email>"
    Given I have also entered a "<username>"
    And I have also selected a "<password>"
    When I press sign up
    Then the "<result>" should be on the screen
    Examples:
      | email | username | password | result |
      |Hejhejhej@lprv.se| Bordefunka1 | Alltgarsomdeska23!   |  |
    |hejhejhej@apa.com| aaaaaaaaaaeeeeeeeeeerrrrrrrrrrtttttttttttgggggggggggvvvvvvvvvvssssssssssssssggggggggggggbbbbbbbbbbbbbbbbbbbbssssssssss| hejHejhje1234!||
      |Hejhejhej@lprv.se| Bordefunka1 | Alltgarsomdeska23!   |  |
    |                 |Anvandareutanemail| ingetGarsomdetska123!||
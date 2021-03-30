Feature: Mailchimp test
  In order to sign up different user i want to everything to run smooth.

  @mytag
  Scenario: Sign up account
    Given I have entered my "abc@abc.se"
    Given I have also entered a "Mjaumau"
    And I have also selected a "Mjaumjau123?"
    When I press sign up
    Then the "result" should be on the screen



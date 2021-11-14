# Created by 14653 at 2021/11/14
Feature:  Register Button functionality test

  Background:

    Given the home page is opened
    And the Sign In button is clicked

    Scenario Outline:
      Given the '<field>' is filled with '<parameter>' in register
      When the Create An Account button is clicked
      Then the '<msg>' error message is shown in register
        Examples:
          | field         | parameter         | msg                        |
          | email_create  |                   | Invalid email address.     |
          | email_create  | invalid.email.com | Invalid email address.     |
          | email_create  | asd@asd.com   | An account using this email address has already been registered. Please enter a valid password or request a new one.      |
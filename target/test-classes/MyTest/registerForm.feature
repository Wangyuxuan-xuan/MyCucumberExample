# Created by 14653 at 2021/11/14
Feature:  Register Form functionality test

  Background:

    Given the home page is opened
    And the Sign In button is clicked
    And the register email address is filled with "some108@gmail.com"
    And the Create An Account button is clicked

    And the Customer First Name is filled with "Max" in register form
    And the Customer Last Name is filled with "Wang" in register form
    And the Address First Name is filled with "Max" in register form
    And the Address Last Name is filled with "Wang" in register form
    And the Address Field is filled with "someAddress" in register form
    And the City Field is filled with "Debrecen" in register form

    And the State Field is selected with "Alaska" in register form
    And the Country Field is selected with "United States" in register form

    And the Mobile Number Field is filled with "00112233" in register form
    And the Alias Field is filled with "someAddr" in register form

    #And the Zip Code Field is filled with '<parameter>' in register form
    #And the Password is filled with '<parameter>' in register form


  Scenario Outline: Test password field
    Given the '<passwordField>' is filled with '<passwdParameter>' in register form
    And the Zip Code Field is filled with "00000" in register form
    When the Register button is clicked
    Then the '<msg>' error message is shown in register form
      Examples:
        | passwordField    | passwdParameter          |msg                        |
        | passwd           |                          |passwd is required.        |
        | passwd           |  word                    |passwd is invalid.         |
        #| passwd           |  validPassword           |                           |

  Scenario Outline: Test zip Code field
    Given the '<zipCodeField>' is filled with '<zipCodeParameter>' in register form
    And the Password Field is filled with "validPassword" in register form
    When the Register button is clicked
    Then the '<msg>' error message is shown in register form
      Examples:
        | zipCodeField    | zipCodeParameter    |msg                                                                                    |
        | postcode        |                     |The Zip/Postal code you\'ve entered is invalid. It must follow this format: 00000      |
        | postcode        |  zipCode            |The Zip/Postal code you\'ve entered is invalid. It must follow this format: 00000      |
        | postcode        |  005                |The Zip/Postal code you\'ve entered is invalid. It must follow this format: 00000      |


  #Scenario Outline: Test mobile phone
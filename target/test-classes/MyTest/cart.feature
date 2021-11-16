# Created by 14653 at 2021/11/14

Feature: cart functionality test

  Background:
    Given the home page is opened

  Scenario:
    Given the Cart button is clicked
    Then the "Your shopping cart is empty." error message is shown in cart

  Scenario: cart add item test
      Given the item "Faded Short Sleeve T-shirts" is added to cart
      And the proceed to check out button is clicked
      When the Cart button is clicked
      Then the item "Faded Short Sleeve T-shirts" is listed in cart


  Scenario: cart delete item test
    Given the item "Faded Short Sleeve T-shirts" is added to cart
    And the proceed to check out button is clicked
    And the item is removed form cart
    When the Cart button is clicked
    Then the item "Faded Short Sleeve T-shirts" is not listed in cart

  Scenario: cart item null quantity test
    Given the item "Faded Short Sleeve T-shirts" is added to cart with quantity of "0"
    Then the "Null quantity." error message is shown in the adding page


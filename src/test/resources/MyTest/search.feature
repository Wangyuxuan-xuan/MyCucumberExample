# Created by 14653 at 2021/11/14
Feature:  search feature functionality test

  Background:

    Given the home page is opened

  Scenario Outline: Invalid search test with Enter key
    Given the '<searchField>' is filled with '<parameter>' in search field
    When the search button is clicked
    Then the '<msg>' error message is shown in search
    Examples:
      | searchField         | parameter         | msg                        |
      | search_query_top        |                   | Please enter a search keyword     |
      | search_query_top        | unknown item | No results were found for your search "unknown item"     |

    Scenario: Empty search test with Enter key
      Given the "search_query_top" is filled with "" in search field
      When the Enter button is pressed
      Then the "Please enter a search keyword" error message is shown in search

    Scenario: Multiple suggestions search
      Given the "search_query_top" is filled with "Printed Summer Dress" in search field
      When the search button is clicked
      Then the related item "Printed Summer Dress" is listed in search

    Scenario: Unique suggestion search
      Given the "search_query_top" is filled with "Faded Short Sleeve T-shirts" in search field
      When the search button is clicked
      Then the related unique item "Faded Short Sleeve T-shirts" is listed in search


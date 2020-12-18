@KEYWORD_MATCHING
Feature: A keyword when attempted to be matched returns context if found a match and if not matched sends back appropriate response message

  Scenario: A keyword when matched a context is returned
    Given Keyword truth
    When The keyword is attempted to be matched
    Then A response code 200 is obtained
    And The search context It is a truth universal is obtained

  Scenario: A keyword when not matched different
    Given Keyword different text
    When The keyword is attempted to be matched
    Then A response code 404 is obtained
    And An Error message Cannot find any matches for keyword: 'different text' is obtained
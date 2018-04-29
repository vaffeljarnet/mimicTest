@tag
Feature: Test how mock responds depending on the current state

  @tag1
  Scenario: Title of your scenario
    Given that the moch has learned that 1+1 is 2
    And that 2+2 is 4
    And that 3+3 is 6
    When I call resetState 
    Then it goes to the previous state
   



    #Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

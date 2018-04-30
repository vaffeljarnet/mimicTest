@tag
Feature: Test how mock responds depending on the current state

  @tag1
  Scenario: Title of your scenario
    Given that the mock has learned that <question> is <response>
    And that <question2> is <response2>
    And that <question3> is <response3>
    When I call resetState 
    Then it goes to the previous state
   



    
      | question| response | question2  | response2 | question3 |resopnse3| 
      | "1+1"   |     "2"  |   "2+2"    | "4"       | "3+3"     | "6"     |

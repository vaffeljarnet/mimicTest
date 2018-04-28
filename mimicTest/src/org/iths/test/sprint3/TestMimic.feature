
@tag
Feature: Test the Mimic functions

  @tag1
  Scenario: Unlearn all 
    Given that the mock has learned requests and responses
    When I write unlearnAll in url
    Then the mock unlearns all responses 


   
   # Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |

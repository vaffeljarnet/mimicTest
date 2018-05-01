
Feature: As a Tester I would like to reset the state so that I can run a complete test scenario
 
  Scenario Outline: Reset with one state in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <questionOne>
    When resetState is called 
    Then the <responseOne> is displayed
    
    Examples: 
      | name  | value | status  |
     

  Scenario Outline: Reset with multiple state in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <question>
    And the mock has learned <responseTwo> with <question>
    And the mock has learned <responseThree> with <question>
    When resetState is called 
    Then the <responseOne> is displayed
    

    Examples: 
      | name  | value | status  |
      
  Scenario Outline: Reset with multiple state with same response in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <question>
    And the mock has learned <responseTwo> with <question>
    And the mock has learned <responseOne> with <question>
    When resetState is called 
    Then the <responseOne> is displayed
    
        Examples: 
      | name  | value | status  |
      
  Scenario Outline: Reset with multiple state with same response in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <question>
    And the mock has learned <responseTwo> with <question>
    And the mock has learned <responseOne> with <question>
    When unlearn is called
    When resetState is called
    Then the <responseOne> is displayed
    
        Examples: 
      | name  | value | status  |
      
    
      
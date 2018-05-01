
Feature: As a Tester I would like to reset the state so that I can run a complete test scenario
 @resetState111
  Scenario Outline: Reset with one state in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <questionOne>
    When resetState is called 
    Then the <responseOne> is displayed
    
    Examples: 
      | responseOne  | questionOne |
      | 3            | 1 + 2    |
     
@resetState112
  Scenario Outline: Reset with multiple state in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <questionOne>
    And the mock has learned <responseTwo> with <questionOne>
    And the mock has learned <responseThree> with <questionOne>
    When resetState is called 
    Then the <responseOne> is displayed
    

    Examples: 
      | responseOne  |responseTwo |responseThree|questionOne |
      | 3            |          4 |    5        |  1 + 2  |
   
  @resetState113   
  Scenario Outline: Reset with multiple state with same response in the request
    Given that the mimicService is running
    And the mock has learned <responseOne> with <questionOne>
    And the mock has learned <responseTwo> with <questionOne>
    And the mock has learned <responseOne> with <questionOne>
    When resetState is called 
    Then the <responseOne> is displayed
    
    Examples: 
     | responseOne  |responseTwo |questionOne |
     | 3            |          4 |  1 + 2  |
     
  
  #@resetState114   
 # Scenario: Reset with multiple state with same response calling unlearn in the request
   # Given that the mimicService is running
   # And the mock has learned <responseOne> with <question>
   # And the mock has learned <responseTwo> with <question>
   #And the mock has learned <responseOne> with <question>
   #When unlearn is called
   # When resetState is called
   # Then the <responseOne> is displayed
    
   
      
    
      
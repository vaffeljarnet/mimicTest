
Feature: As a Tester I would like to reset the state so that I can run a complete test scenario
 @resetState111
  Scenario Outline: Reset with one state in the request
    Given that the mimicService is running
     And that the mock has learned <questionOne> with <responseOne>
    When I call resetState for <questionOne> 
    Then the <responseOne> is displayed when <questionOne> is called
    
     Examples:
      | questionOne| responseOne | 
      | "1+1"      |     "2"     |
   
   
     
@resetState112
  Scenario Outline: Reset with multiple state in the request
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionOne> with <responseTwo>
    And that the mock has learned <questionOne> with <responseThree>
    When I call resetState for <questionOne> 
    Then the <responseOne> is displayed when <questionOne> is called
    
     Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
   
   
  @resetState113   
  Scenario Outline: Reset with multiple state with same response in the request
    Given that the mimicService is running
     And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionOne> with <responseTwo>
    And that the mock has learned <questionOne> with <responseOne>
    When I call resetState for <questionOne>
    Then the <responseOne> is displayed when <questionOne> is called
    
     Examples:
      | questionOne| responseOne | responseTwo |
      | "1+1"      |     "2"     | "4"         |   
 
     
  
  #@resetState114   
 # Scenario: Reset with multiple state with same response calling unlearn in the request
   # Given that the mimicService is running
   # And the mock has learned <responseOne> with <question>
   # And the mock has learned <responseTwo> with <question>
   #And the mock has learned <responseOne> with <question>
   #When unlearn is called
   # When resetState is called
   # Then the <responseOne> is displayed
    
   
      
    
      
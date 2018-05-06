
Feature: As a Tester I would like the mock to learn how to respond differently depending 
on the current state to simulate the internal state of the SUT

@currentState111
  Scenario Outline: Unlearn question with multiple states
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionOne> with <responseTwo>
    And that the mock has learned <questionOne> with <responseThree>
    When I call unlearn for <questionOne>
    Then the mock unlearns <questionOne>
   
    Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
   
 @currentState112     
   Scenario Outline: Unlearn question with one state
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I call unlearn for <questionOne>
    Then the mock unlearns <questionOne> 
    
     Examples:
      | questionOne| responseOne | 
      | "1+1"      |     "2"     |         
 //stepBack ska tas bort
 @currentState113 
  Scenario Outline: Step one state back
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionOne> with <responseTwo>
    And that the mock has learned <questionOne> with <responseThree>
    When I call stepBack for <questionOne>
    Then <questionOne> respondes with <responseTwo>
    
     Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
   
   
  @currentState114 
   Scenario Outline: Set new state for request
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I teach the mock that <questionOne> has response <responseTwo>
    When I teach the mock that <questionOne> has response <responseThree>
    Then <questionOne> respondes with <responseThree>

    Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
  
  
 @currentState115    
   Scenario Outline: Unlearn multiple states with same response
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionOne> with <responseTwo>
    And that the mock has learned <questionOne> with <responseOne>
    When I call unlearn for <questionOne>
    And I call unlearn for <questionOne>
    Then <questionOne> respondes with <responseOne>

    Examples:
      | questionOne| responseOne | responseTwo | 
      | "1+1"      |     "2"     | "3"         |

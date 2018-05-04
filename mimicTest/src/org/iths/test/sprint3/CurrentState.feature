
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
      
@currentState113

	Scenario Outline: Store sequense and check that all states are stored
	  Given that the mimicService is running
	  And that the mock has learned <questionOne> with <responseOne>
	  When I teach the mock that <questionOne> has response <responseTwo>
	  And I teach the mock that <questionOne> has response <responseThree>
	  And I teach the mock that <questionOne> has response <responseFour>
	  When I call resetState
	  Then every step in the stored sequense respondes with the correct response as bellow
	    |  question   |    response   |
      |   "1+1"     |      "2"      |
      |   "1+1"     |      "3"      |
      |   "1+1"     |      "4"      |
      |   "1+1"     |      "5"      |
      
      Examples:
      | questionOne| responseOne | responseTwo| responseThree|responseFour|
      |   "1+1"    |     "2"     |     "3"    |     "4"      |     "5"    |
	  
   
  @currentState114 
   Scenario Outline: Set new state for request
    Given that the mimicService is running
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

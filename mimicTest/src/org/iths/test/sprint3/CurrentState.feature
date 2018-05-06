
Feature: As a Tester I would like the mock to learn how to respond differently depending 
on the current state to simulate the internal state of the SUT

@currentState111
  Scenario: Unlearn removes the current and following states
    Given that the mimicService is running
    And that no requests are stored
		When I teach the mock the below sequense
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |
	  And I call resetState
	  And I make the request "1+1"
		And I make the request "1+1"
		And I make the request "1+1"
		And I call unlearn
		And I make the request "1+1"
	  Then "1+1" respondes with "3"

    
 @currentState112     
   Scenario Outline: Unlearn question with one state
    Given  that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I call unlearn
    Then the mock unlearns <questionOne> 
    
     Examples:
      | questionOne| responseOne | 
      | "1+1"      |     "2"     |         
 
  @currentState113 
   Scenario Outline: Set new state for request
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I teach the mock that <questionOne> has response <responseTwo>
    When I teach the mock that <questionOne> has response <responseThree>
    Then <questionOne> respondes with <responseThree>

    Examples:
      | questionOne| responseOne | responseTwo |responseThree| 
      | "1+1"      |     "2"     | "4"         |   "6"       |
	  
	@currentState114
	Scenario: Store sequense and check that all states are stored after reset
	  Given that the mimicService is running
	  And that no requests are stored
	  When I teach the mock the below sequense
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |
	  And I call resetState
	  Then every step in the stored sequense respondes with the stored response as below
	    |  question   |    response   |
      |    1+1      |       2       |
      |    1+1      |       3       |
      |    1+1      |       4       |
      |    1+1      |       5       |



Feature: Unlearn all responses so that I can rerun all the tests without restarting the service

@unlearnAll111
  Scenario Outline: Unlearn all with two request
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionTwo> with <responseTwo>
    When I write unlearnAll in url
    Then the mock unlearns <questionOne>
    And the mock unlearns <questionTwo>
    
  Examples:
    | questionOne  | responseOne | questionTwo  | responseTwo |
    | "1+1"        |     "2"     |   "2+2"      |    "4"      |
 
 @unlearnAll112   
  Scenario Outline: Unlearn all with one request
   Given that the mimicService is running
   And that the mock has learned <questionOne> with <responseOne>
   When I write unlearnAll in url
   Then the mock unlearns <questionOne> 
	
	Examples:
   | questionOne  | responseOne |
   | "1+1"        |     "2"     | 

 @unlearnAll113
	Scenario: Unlearn all with no requests stored
 		Given that the mimicService is running
 		And that no requests are stored
 		When I write unlearnAll in url
 		Then the mock shows error message

   
        
      

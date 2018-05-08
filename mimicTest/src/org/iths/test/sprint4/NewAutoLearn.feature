Feature: As a Tester I would like the mock to learn how to respond 
				to requests that I have not defined so that I do not 
        have to create code for that manually (only add, mult, sub and div)
@AutoLearn111
  Scenario Outline: Learn how to calculate add, sub, mult and div with one digit values
    Given that the mimicService is running
    When I teach the mock that <questionOne> has response <responseOne>
    And I teach the mock that <questionTwo> has response <responseTwo>
    Then <notKnownQuestion> respondes with <notKnownResponse>
    
    Examples:
    	|       questionOne       | responseOne |       questionTwo          | responseTwo |     notKnownQuestion       | notKnownResponse |
 			| "add?value1=1&value2=1" |    "2"      |   "add?value1=1&value2=2"  |     "3"     |  "add?value1=1&value2=3"   |       "4"        |
 			|"sub?value1=5&value2=1"  |    "4"      |   "sub?value1=5&value2=2"  |     "3"     |  "sub?value1=5&value2=3"   |       "2"        |
 			|"mult?value1=3&value2=2" |    "6"      |  "mult?value1=3&value2=3"  |     "9"     |  "mult?value1=3&value2=4"  |       "12"       |
 			|"div?value1=4&value2=2"  |    "2"      |  "div?value1=60&value2=20" |     "3"     |  "div?value1=8&value2=4"   |       "2"        |


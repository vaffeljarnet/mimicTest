@tag
Feature: Relearn, unlearn and resetState functionality

  @Functionality111
  Scenario: Relearn adds states to request
    Given that the mimicService is running
    When I open the url "1+1"
    And I input "2" in the response form
    And I press the learn button
    And I make the request "1+1"
    And I open the relearn URL
    And I input "3" in the response form
    And I press the learn button
    And I close the browser
    And I call resetState
    Then "1+1" respondes with "2"
   
   @Functionality112
   Scenario: Relearn edits the last requested state in a sequense
    Given that the mimicService is running
    And the mock has learned the below sequense
    	|question|response|
    	|  ABC	 |	 A    |
    	|  ABC	 |	 D    |
    	|  ABC	 |	 C    |
    When I call resetState
    And I open the url "ABC"
    And I enter the url "localhost:8080/ABC"
    And I enter the url "localhost:8080/relearn"
    And I input "B" in the response form
    And I press the learn button
    And I enter the url "localhost:8080/resetState"
    And I enter the url "localhost:8080/ABC"
    And I enter the url "localhost:8080/ABC"
    And I close the browser
    Then "ABC" respondes with "B"
    
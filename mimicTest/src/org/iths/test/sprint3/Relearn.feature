Feature: Relearn function with web interface

  @Relearn111
  Scenario Outline: Correct wrong response with web interface
    Given that the mimicService is running
    And that no requests are stored
    When I open the url <question>
    And I input <wrongResponse> in the response form
    And I press the learn button
    And I open the url <question>
    And I open the relearn URL
    And I input <correctResponse> in the response form
    And I press the learn button
    And I close the browser
    Then <question> respondes with <correctResponse>

    Examples: 
      |  question   | wrongResponse | correctResponse  |
      |   "1+1"     |     "1"       |       "2"        |
    

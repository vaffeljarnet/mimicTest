
Feature: Response form mime type recogniction

  @MimeTypeRec111
  Scenario Outline: Store mime type response with response form
    Given that the mimicService is running
    When I open the url <question>
    And I input <response> in the response form
    And I press the learn button
    And I close the browser
    Then the request <question> has the mime type <mimeType>

    Examples: 
      |    question    |                    response    			  			     |      mimeType       |
      |   "TEXT"       |                  "TextMime"   								  	 | "application/text;" |
      |   "JSON"       |       "{ /'name/':/'John/', /'age/':30 }"         | "application/json;" |
      |   "XML"        |         "<note><to>Test</to></note>"              | "application/xml;"  |
      |   "HTML"       |   "<!DOCTYPE html><html><body></body></html>"     | "application/html;" |
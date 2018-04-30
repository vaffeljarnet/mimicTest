
@tag
Feature: Test the Mimic functions

  @tag1
  Scenario: Unlearn all with two request
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    And that the mock has learned <questionTwo> with <responseTwo>
    When I write unlearnAll in url
    Then the mock unlearns <questionOne>
    And the mock unlearns <questionTwo>
    
    Scenario: Unlearn all with one request
    Given that the mimicService is running
    And that the mock has learned <questionOne> with <responseOne>
    When I write unlearnAll in url
    Then the mock unlearns <questionOne> 

Scenario: Unlearn all with no requests stored
 Given that the mimicService is running
 And that no requests are stored
 When I write unlearnAll in url
 Then the mock shows error message

   
     
      | questionOne  | responseOne | questionTwo  | responseTwo |
      | "1+1"      |     "2"   |   "2+2"    |    "4"    |
      

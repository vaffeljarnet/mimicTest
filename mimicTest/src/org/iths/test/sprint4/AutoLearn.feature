@tag
Feature: As a Tester I would like the mock to learn how to respond 
				to requests that I have not defined so that I do not 
        have to create code for that manually (only add, mult, sub and div)

@tag1
  Scenario: Learn how to divide values with each other
    Given that the mimicService is running
    When I teach the mock the below questions and responses
    	|        question           |response|
    	|  div?value1=4&value2=2    |    2   |
    	|  div?value1=60&value2=20  |    3   |
    Then "div?value1=50&value2=5" respondes with "10"

@tag1
  Scenario: Learn how to multiply values with each other
    Given that the mimicService is running
    When I teach the mock the below questions and responses
    	|        question           |response|
    	|  mult?value1=3&value2=2   |    6   |
    	|  mult?value1=3&value2=3   |    9   |
    Then "mult?value1=3&value2=4" respondes with "12"

@tag1
  Scenario: Learn how to subtract values from each other
    Given that the mimicService is running
    When I teach the mock the below questions and responses
    	|        question           |response|
    	|  sub?value1=5&value2=1    |    4   |
    	|  sub?value1=5&value2=2    |    3   |
    Then "sub?value1=5&value2=3" respondes with "2"

  @tag1
  Scenario: Learn how to add values together
    Given that the mimicService is running
    When I teach the mock the below questions and responses
    	|        question           |response|
    	|  add?value1=1&value2=1    |    2   |
    	|  add?value1=1&value2=2    |    3   |
    Then "add?value1=1&value2=3" respondes with "4"

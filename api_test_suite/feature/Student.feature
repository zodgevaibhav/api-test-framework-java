@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario: Student details should be updates in database
    Given Test case name is "Verify student is able to update in Database"
    And Test case id is "TC_001"
    When I get "XML" template of request "Student"
    And I update node "//from" value to "VaibhavZodge"
    Then I verify response value of node "//from" is "VaibhavZodge"

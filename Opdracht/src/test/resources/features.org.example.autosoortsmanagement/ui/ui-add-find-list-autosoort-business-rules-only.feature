# Created by Dawa at 21.12.24
Feature: Add a autosoort via the UI - Business rules only
  @UI
  Scenario: add a autosoort to the known autosoorts business rules only
    Given I am on the page where I can introduce a new autosoort
    When I enter the necessary details for a autosoort
    Then I should be able to look up and find that autosoort
    And the data of that autosoort should show up in the list



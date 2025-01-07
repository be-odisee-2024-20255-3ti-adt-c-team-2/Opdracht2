# Created by Dawa at 21.12.21
Feature: List all known autosoorts via the UI

  A Customer Service Representatieve (CSR)
  can list all known autosoorts

  @UI
  Scenario: List all known autosoorts
    Given I am on the page where I can introduce a new autosoort
    And 3 autosoorts were introduced
    And  I am on the page where I can find a autosoort
    Given I am on the page where I can list the known autosoorts
    When I click on the List Autosoorts button
    Then I should see a text containing "Model X" and "Model a8" and "Chin"



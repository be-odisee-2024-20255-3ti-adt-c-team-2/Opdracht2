# Created by Dawa at 21.12.24
Feature: Find a autosoort by their name via the UI

  A Customer Service Representatieve (CSR)
  can find a autosoort by their name

  Background:
    Given I am on the page where I can introduce a new autosoort
    And 4 autosoorts were introduced
    And  I am on the page where I can find a autosoort

  @UI
  Scenario: Find an existing autosoort by their name
    When I enter "Model X" in the naamToBeFound field for searching
    And I click the Search Autosoort button
    Then I should see a message "Gevonden: Model X Tesla"

  @UI
  Scenario: Do not find a non-existing autosoort by a fake name
    When I enter "Odisee" in the naamToBeFound field for searching
    And I click the Search Autosoort button
    Then I should see an alert "Server returned 404"


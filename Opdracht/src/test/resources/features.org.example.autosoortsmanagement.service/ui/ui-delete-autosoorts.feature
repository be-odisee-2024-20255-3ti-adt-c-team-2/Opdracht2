# Created by Dawa at 21.12.24
Feature: Delete all known autosoorts via the UI

  A Customer Service Representatieve (CSR)
  can delete all known autosoorts -- don't do this for real :-)

  @UI
  Scenario: Delete all known persons
    Given I am on the page where I can introduce a new autosoort
    And 4 autosoorts were introduced
    And  I am on the page where I can delete autosoorts
    When I click the Delete Autosoorts button
    And I click on the List Autosoorts button
    Then I should see an empty list


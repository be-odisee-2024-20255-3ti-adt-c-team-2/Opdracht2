# Created by Dawa at 21.12.24
Feature: Add a autosoort via the UI

  A Customer Service Representative (CSR)b
  can add a autosoort with naam, merk, huidigevoorraad, minimum & maximumpeiler
  The CSR will be provided containing a unique id

  @UI
  Scenario: add a autosoort to the known autosoorts
    Given I am on the page where I can introduce a new autosoort
    When I enter "Model I" in the naam field
    And I enter "Tesla" in the merk field
    And I enter "4" in the huidigVoorraadniveau field
    And I enter "1" in the min field
    And I enter "20" in the max field
    And I click the Add autosoort button
    Then I should see a message containing "Autosoort gecreëerd met id"


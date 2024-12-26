Feature: List all known autosoorten via the API

  A Customer Service Representatieve (CSR)
  can list all known autosoorten

  Scenario: List all known autosoorten
    # The following request url is valid for DELETE-ing POST-ing the initial data too
    Given a request url "/api/v1/autosoorten"
    And the following autosoorten are known
      | Naam     | Merk       | Voorraad       |
      | Audi A8  | Audi       | 1              |
      | Tesla    | Tesla      | 1              |
      | test 3   | test       | 1              |
    When the request sends GET
    Then the response status is "200 OK"
    And the response json contains a list with details of 3 Autosoort objects
    And the Voorraad-attribute of the Autosoort object 1 contains "1"
    And the Voorraad-attribute of the Autosoort object 2 contains "1"
    And the Voorraad-attribute of the Autosoort object 3 contains "1"

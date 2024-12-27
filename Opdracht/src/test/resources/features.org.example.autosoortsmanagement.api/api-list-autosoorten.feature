Feature: List all known autosoorten via the API

  A Customer Service Representative (CSR)
  can list all known autosoorten

  Scenario: List all known autosoorten
    # The following request url is valid for DELETE-ing POST-ing the initial data too
    Given a request url "/api/v1/autosoorten"
    And the following autosoorten are known
      | naam     | merk       | huidigVoorraadniveau       |
      | Audi A8  | Audi       | 5              |
      | Tesla    | Tesla      | 2              |
      | test 3   | test       | 3              |
    When the request sends GET
    Then the response status is "200 OK"
    And the response json contains a list with details of 3 Autosoort objects
    And the "huidigVoorraadniveau" attribute of the Autosoort object is at least 1


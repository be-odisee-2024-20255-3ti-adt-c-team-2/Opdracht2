Feature: Delete all known autosoorten via the API

  A Customer Service Representatieve (CSR)
  can delete all known autosoorten

  Scenario: Delete all known persons
    Given a request url "/api/v1/autosoorten"
    When the request sends DELETE
    Then the response status is "204 No Content"
    And the response is empty

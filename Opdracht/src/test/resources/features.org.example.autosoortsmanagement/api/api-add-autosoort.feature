## Created by hans at 06.12.21
#Feature: Add a autosoort via the API
#
#  A Customer Service Representative (CSR)
#  can add a person with naam, merk
#  The CSR will be provided with a unique id
#
#  Scenario: add a autosoort to the known autosoorten
#    Given a request url "/api/v1/autosoorten"
#    And a request json payload
#    """
#    {
#        "autosoortId": 4,
#        "status": "Niet in bestelling",
#        "naam": "Model S",
#        "merk": "Tesla",
#        "huidigVoorraadniveau": 4,
#        "minimumpeiler": 1,
#        "maximumpeiler": 10,
#        "marktvraag": null,
#        "id": 4
#    }
#    """
#    When the request sends POST
#    Then the response status is "201 Created"
#    And the response json contains the details of a Autosoort object
#    And the "id"-attribute of the Autosoort object contains a nonzero number
#    And the "naam"-attribute of the Autosoort object  contains "Model S"
#    And the "merk"-attribute of the Autosoort object  contains "Tesla"

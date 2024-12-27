package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return autosoort with non null id")
    request {
        method POST()
        url("/api/v1/autosoorten")
        headers { contentType applicationJson() }
        body(
                [
                        "naam":"Model U","merk":"Tesla","huidigVoorraadniveau":1,"minimumpeiler":1,"maximumpeiler":10

                ]
        )
    }
    response {
        body(
                [
                        "autosoortId":1,"naam":"Model U","merk":"Tesla","huidigVoorraadniveau":1,"minimumpeiler":1,"maximumpeiler":10

                ]
        )
        status(201)
    }
}

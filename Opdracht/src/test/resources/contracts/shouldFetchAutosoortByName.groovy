package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("should return an autosoort when queried by naam")
    request {
        method GET()
        urlPath("/api/v1/autosoorten/Model U")
        headers { accept applicationJson() }
    }
    response {
        status 200
        body(
                [
                        "autosoortId": 1,
                        "naam": "Model U",
                        "merk": "Tesla",
                        "huidigVoorraadniveau": 1,
                        "minimumpeiler": 1,
                        "maximumpeiler": 10
                ]
        )
    }
}

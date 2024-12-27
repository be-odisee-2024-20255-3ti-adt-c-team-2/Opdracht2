package org.example;

import org.example.BaseTestClass;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;

import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;
import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SuppressWarnings("rawtypes")
public class ContractVerifierTest extends BaseTestClass {

	@Test
	public void validate_shouldAddAutorsoortAndReturnWithId() throws Exception {
		// given:
			MockMvcRequestSpecification request = given()
					.header("Content-Type", "application/json")
					.body("{\"naam\":\"Model U\",\"merk\":\"Tesla\",\"huidigVoorraadniveau\":1,\"minimumpeiler\":1,\"maximumpeiler\":10}");

		// when:
			ResponseOptions response = given().spec(request)
					.post("/api/v1/autosoorten");

		// then:
			assertThat(response.statusCode()).isEqualTo(201);

		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['autosoortId']").isEqualTo(1);
			assertThatJson(parsedJson).field("['naam']").isEqualTo("Model U");
			assertThatJson(parsedJson).field("['merk']").isEqualTo("Tesla");
			assertThatJson(parsedJson).field("['huidigVoorraadniveau']").isEqualTo(1);
			assertThatJson(parsedJson).field("['minimumpeiler']").isEqualTo(1);
			assertThatJson(parsedJson).field("['maximumpeiler']").isEqualTo(10);
	}

}

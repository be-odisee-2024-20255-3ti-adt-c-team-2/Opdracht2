package org.example.steps;

import org.example.domein.Autosoort;

import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

// @CucumberContextConfiguration en @SpringBootTest zitten in CucumberSpringConfiguration
public class MyStepdefsAPI {

    String theUrl = null;
    String theRequestData = null;

    HttpStatus httpStatus;
    HashMap theResponseData = null;
    String theResponseJsonList;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private WebTestClient webTestClient;

    WebTestClient.ResponseSpec responseSpec;
    WebTestClient.ListBodySpec<Autosoort> listBodySpec;
    Autosoort returnedAutosoort = null;
    List<Autosoort> returnedAutosoorten = null;

    HttpHeaders headers;
    HttpEntity requestHttpEntity;

    @Given("a request url {string}")
    public void aRequestUrl(String url) {
        this.theUrl = url;
    }

    @And("a request json payload")
    public void aRequestJsonPayload(String jsonPayload) {
        this.theRequestData = jsonPayload;
    }

    @When("the request sends POST")
    public void theRequestSendsPOST() throws JsonProcessingException {
        this.responseSpec = webTestClient
                .post()
                .uri(this.theUrl)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(this.theRequestData)
                .exchange();
    }
    @Then("the response status is {string}")
    public void the_response_status_is(String httpStatus) {
        switch (httpStatus) {
            case "200 OK":
                assertThat(this.responseSpec
                        .expectStatus()
                        .isOk());
                break;
            case "201 Created":
                assertThat(this.responseSpec
                        .expectStatus()
                        .isCreated());
                break;
            case "204 No Content":
                assertThat(this.responseSpec
                        .expectStatus()
                        .isNoContent());
                break;
            case "404 Not Found":
                assertThat(this.responseSpec
                        .expectStatus()
                        .isNotFound());
                break;
            default:
                // Er wordt een httpStatus verwacht die we nog niet voorzien hebben
                assertThat(true).isFalse();
        }
    }
    @Then("the response json contains the details of a Autosoort object")
    public void the_response_json_contains_the_details_of_a_autosoort_object() {
        this.returnedAutosoort = this.responseSpec
                .returnResult(Autosoort.class)
                .getResponseBody()
                .blockFirst();
        assertThat(this.returnedAutosoort).isNotNull();
    }
    @Then("the {string}-attribute of the Autosoort object contains a nonzero number")
    public void the_attribute_of_the_autosoort_object_contains_a_nonzero_number(String string) {
        assertThat(this.returnedAutosoort.getId()).isNotEqualTo(0);
    }
    @Then("the {string}-attribute of the Autosoort object  contains {string}")
    public void the_attribute_of_the_autosoort_object_contains(String field, String value) throws NoSuchFieldException, IllegalAccessException {
        // Hier moeten we reflection toepassen om de waarde van het attribuut field op te pikken
        java.lang.reflect.Field f = Autosoort.class.getDeclaredField(field);
        f.setAccessible(true);  // omdat het veld "private" gedeclareerd staat
        assertThat(f.get(returnedAutosoort)).isEqualTo(value);
    }
    @When("the request sends DELETE")
    public void the_request_sends_delete() {
        this.responseSpec = webTestClient
                .delete()
                .uri(this.theUrl)
                .exchange();
    }
    @Then("the response is empty")
    public void the_response_is_empty() {
        assertThat(this.responseSpec
                .expectBody()
                .isEmpty());
    }
    @When("the following autosoorten are known")
    public void theFollowingAutosoortenAreKnown(DataTable autosoortenDatatable) {

        // Verkrijg de dataTable als een lijst van Map-objecten
        List<Map<String, String>> dataTable = autosoortenDatatable.asMaps();

        // Vertrek van 0 bekende personen - reeds geteste werkwijze
        webTestClient.delete().uri(this.theUrl).exchange();

        // Overloop elke rij ... voeg de data toe
        for (Map<String, String> rowFromTable : dataTable) {
            // Construeer een AutosoortData-object met de gegevens van één rij
            Autosoort autosoort = new Autosoort();
            for (Map.Entry<String, String> entry : rowFromTable.entrySet()) {
                if (entry.getKey().equals("naam")) autosoort.setNaam(entry.getValue());
                if (entry.getKey().equals("merk")) autosoort.setMerk(entry.getValue());
            }
            // Gebruik de al geteste service methode om autosoort toe te voegen
            webTestClient
                    .post()
                    .uri(this.theUrl)
                    .bodyValue(autosoort)
                    .accept(MediaType.APPLICATION_JSON)
                    .exchange();
        }
    }
    @When("the request sends GET")
    public void the_request_sends_get() {
        this.responseSpec = webTestClient
                .get()
                .uri(this.theUrl)
                .exchange();
    }
    @Then("the response json contains a list with details of {int} Autosoort objects")
    public void the_response_json_contains_a_list_with_details_of_autosoort_objects(Integer number) {
        this.returnedAutosoorten = this.responseSpec
                .returnResult(Autosoort.class)
                .getResponseBody()
                .collectList().block();

        assertThat(this.returnedAutosoorten.size()).isEqualTo(number);
    }
}
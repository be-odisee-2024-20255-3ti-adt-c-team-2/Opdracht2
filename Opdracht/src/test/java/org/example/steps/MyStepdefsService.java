package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.nl.Als;
import io.cucumber.java.nl.Dan;
import io.cucumber.java.nl.En;
import io.cucumber.java.nl.Gegeven;
import org.example.service.AutosoortService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

// @CucumberContextConfiguration en @SpringBootTest zitten in CucumberSpringConfiguration
public class MyStepdefsService {

    private long lastInsertedId = 0;
    private String lastDBResult = null;
    private List<String> lastDBListResult = null;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    AutosoortService autosoortService;

    @Gegeven("er zijn geen bekende autosoorten")
    public void erZijnGeenBekendeAutosoorten() {
        autosoortService.forgetKnownAutosoorten();
        assertThat(autosoortService.countKnownAutosoorten()).isEqualTo(0);
    }

    @Gegeven("er zijn {int} bekende autosoorten")
    public void erZijnBekendeAutosoorten(int aantal, DataTable autosoortenDataTable) {
        List<Map<String, String>> dataTable = autosoortenDataTable.asMaps();
        autosoortService.forgetKnownAutosoorten();

        for (Map<String, String> row : dataTable) {
            autosoortService.addAutosoort(
                    row.get("naam"),
                    row.get("merk"),
                    Integer.parseInt(row.get("huidigeVoorraadniveau")),
                    Integer.parseInt(row.get("minimumpeiler")),
                    Integer.parseInt(row.get("maximumpeiler"))
            );
        }

        assertThat(autosoortService.countKnownAutosoorten()).isEqualTo(aantal);
    }

    @Als("de LM een autosoort toevoegt met naam {string}, merk {string}, huidig voorraadniveau {int}, minimumpeiler {int} en maximumpeiler {int}")
    public void deLMVoegtEenAutosoortToe(String naam, String merk, int voorraad, int min, int max) {
        this.lastInsertedId = autosoortService.addAutosoort(naam, merk, voorraad, min, max);
    }

    @Dan("is er 1 bekende autosoort")
    public void isErBekendeAutosoort() {
        assertThat(autosoortService.countKnownAutosoorten()).isEqualTo(1);
    }

    @En("krijgt de LM het toegekende uniek id")
    public void krijgtDeLMHetUniekId() {
        assertThat(this.lastInsertedId).isNotEqualTo(0);
    }

    @Dan("zijn er {int} bekende autosoorten")
    public void zijnErBekendeAutosoorten(int aantal) {
        assertThat(autosoortService.countKnownAutosoorten()).isEqualTo(aantal);
    }

    @Als("de Verkoper een lijst van bekende autosoorten opvraagt")
    public void deVerkoperVraagtLijstOp() {
        this.lastDBListResult = autosoortService.showListOfAutosoorten();
    }

    @Dan("krijgt hij {string} als resultaat")
    public void krijgtHijAlsResultaat(String verwachtResultaat) {
        assertThat(lastDBListResult.get(0)).isEqualTo(verwachtResultaat);
    }

    @Dan("krijgt hij als resultaat voor de lijst van bekende autosoorten")
    public void krijgtHijLijstVanBekendeAutosoorten(DataTable verwachtResultaat) {
        List<Map<String, String>> expectedTable = verwachtResultaat.asMaps();
        List<String> actualResult = new ArrayList<>();

        for (Map<String, String> row : expectedTable) {
            String autosoort = row.get("autosoort") + ", " + row.get("huidigeVoorraadniveau");
            actualResult.add(autosoort);
        }

        assertThat(this.lastDBListResult).isEqualTo(actualResult);
    }

    @Als("de Verkoper de autosoort met het toegekende uniek id opzoekt")
    public void deVerkoperZoektAutosoortOpId() {
        this.lastDBResult = autosoortService.searchAutosoortById(lastInsertedId);
    }

    @Dan("krijgt hij {string} als informatie over de gezochte autosoort")
    public void krijgtHijAlsInformatieOverDeGezochteAutosoort(String verwachtResultaat) {
        assertThat(lastDBResult).isEqualTo(verwachtResultaat);
    }

    @Als("de Verkoper de autosoort met naam en merk {string} opzoekt")
    public void deVerkoperZoektAutosoortOpNaamEnMerk(String naamMerk) {
        this.lastDBResult = autosoortService.searchAutosoortByNameAndBrand(naamMerk);
    }
}
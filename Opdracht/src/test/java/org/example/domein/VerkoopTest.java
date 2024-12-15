package org.example.domein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class VerkoopTest {
    private Verkoop verkoop;
    private Autosoort autosoort;
    private Factuur factuur;
    private BeerensMedewerker verkoper;

    @BeforeEach
    void setUp() {
        autosoort = new Autosoort("SUV", "Toyota", 10, 5, 12);
        verkoop = new Verkoop("In Behandeling", new Date(), autosoort, factuur, verkoper);
    }

    @Test
    void testVerkoopInitialization() {
        assertNotNull(verkoop.getId(), "ID mag niet null zijn");
        assertEquals("In Behandeling", verkoop.getStatus(), "Status moet correct worden ingesteld");
        assertNotNull(verkoop.getVerkoopDatum(), "Verkoopdatum mag niet null zijn");
        assertEquals(autosoort, verkoop.getAutosoort(), "Autosoort moet correct worden ingesteld");
        assertEquals(factuur, verkoop.getFactuur(), "Factuur moet correct worden ingesteld");
        assertEquals(verkoper, verkoop.getVerkoper(), "Verkoper moet correct worden ingesteld");
    }

    @Test
    void testAnnuleer() {
        verkoop.annuleer();
        assertEquals("Geannuleerd", verkoop.getStatus(), "Status moet 'Geannuleerd' zijn na annulering");
    }

    @Test
    void testRegistreer() {
        verkoop.registreer();
        assertEquals("Geregistreerd", verkoop.getStatus(), "Status moet 'Geregistreerd' zijn na registratie");
    }
}
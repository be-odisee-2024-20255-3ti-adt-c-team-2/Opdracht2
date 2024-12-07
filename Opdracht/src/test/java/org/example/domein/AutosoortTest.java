package org.example.domein;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutosoortTest {

    private Autosoort autosoort;

    @BeforeEach
    void setUp() {
        autosoort = new Autosoort("Model X", "Tesla", 50, 10, 100);
    }

    @Test
    void testConstructor() {
        assertEquals("Model X", autosoort.getNaam());
        assertEquals("Tesla", autosoort.getMerk());
        assertEquals(50, autosoort.getHuidigVoorraadniveau());
        assertEquals(10, autosoort.getMinimumpeiler());
        assertEquals(100, autosoort.getMaximumpeiler());
        assertEquals("Niet in bestelling", autosoort.getStatus());
    }

    @Test
    void testIsVerkocht() {
        autosoort.isVerkocht(5);
        assertEquals(45, autosoort.getHuidigVoorraadniveau());
    }

    @Test
    void testIsVerkocht_InvalidAantal() {
        assertThrows(IllegalArgumentException.class, () -> autosoort.isVerkocht(-5), "Aantal kan niet negatief zijn.");
    }

    @Test
    void testVoegAnalyseMarktvraagToe() {
        String beschrijving = "Analyse van de vraag naar elektrische auto's";
        autosoort.voegAnalyseMarktvraagToe(beschrijving);

        assertNotNull(autosoort.getMarktvraag());
        assertEquals(beschrijving, autosoort.getMarktvraag().getBeschrijving());
    }

    @Test
    void testBestellingAfgerond() {
        autosoort.bestellingAfgerond();
        assertEquals("Niet in bestelling", autosoort.getStatus());
    }

    @Test
    void testUpdateVoorraad() {
        autosoort.updateVoorraad(80);
        assertEquals(80, autosoort.getHuidigVoorraadniveau());
    }

    @Test
    void testUpdateVoorraad_BelowMinimum() {
        autosoort.updateVoorraad(5);
        assertTrue(autosoort.getHuidigVoorraadniveau() < autosoort.getMinimumpeiler());
    }

    @Test
    void testUpdateVoorraad_AboveMaximum() {
        autosoort.updateVoorraad(150);
        assertTrue(autosoort.getHuidigVoorraadniveau() > autosoort.getMaximumpeiler());
    }
}

package org.example.domein;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AutosoortTest {
    private Autosoort autosoort;

    @BeforeEach
    void setUp() {
        autosoort = new Autosoort("Model X", "Tesla", 7, 3, 10);
    }

    @Test
    void testConstructor() {
        assertEquals("Model X", autosoort.getNaam());
        assertEquals("Tesla", autosoort.getMerk());
        assertEquals(7, autosoort.getHuidigVoorraadniveau());
        assertEquals(3, autosoort.getMinimumpeiler());
        assertEquals(10, autosoort.getMaximumpeiler());
        assertEquals("Niet in bestelling", autosoort.getStatus());
    }

    @Test
    void testIsVerkocht() {
        autosoort.isVerkocht(2);
        assertEquals(5, autosoort.getHuidigVoorraadniveau());

        autosoort.isVerkocht(1);
        assertEquals(4, autosoort.getHuidigVoorraadniveau());
    }

    @Test
    void testVoegAnalyseMarktvraagToe() {
        String beschrijving = "Analyse van vraag naar elektrische auto's";
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
        autosoort.updateVoorraad(8);
        assertEquals(8, autosoort.getHuidigVoorraadniveau());

        autosoort.updateVoorraad(6);
        assertEquals(6, autosoort.getHuidigVoorraadniveau());
    }
}

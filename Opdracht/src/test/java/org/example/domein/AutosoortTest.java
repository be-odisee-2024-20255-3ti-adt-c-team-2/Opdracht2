package org.example.domein;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AutosoortTest {
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
        autosoort.isVerkocht(10);
        assertEquals(40, autosoort.getHuidigVoorraadniveau());

        autosoort.isVerkocht(5);
        assertEquals(35, autosoort.getHuidigVoorraadniveau());
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
        autosoort.updateVoorraad(70);
        assertEquals(70, autosoort.getHuidigVoorraadniveau());

        autosoort.updateVoorraad(30);
        assertEquals(30, autosoort.getHuidigVoorraadniveau());
    }
}

package org.example.o;

import org.example.domein.Autosoort;
import org.example.domein.Bestelling;
import org.example.domein.Levering;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class BestellingTest {

    @Test
    public void testBestelStatementCoverage() {
        // Arrange
        Autosoort autosoort = new Autosoort( "Civic", "Honda",
                10, 1, 20);
        Bestelling bestelling = new Bestelling(autosoort, 4);

        // Act
        bestelling.bestel("12/05/2025"); // verwachtte leverdatum
        Levering levering = bestelling.isGeleverd("20/05/2025",
                autosoort, 4);

        // Assert
        // Controleer of de levering succesvol is gemaakt
        assertNotNull(levering);
    }

<<<<<<< Updated upstream

/*
2. Decision Coverage
Doel: Elke beslissingsuitkomst (waar/vals) moet minstens één keer worden getest.
Testbasis: Voeg een if-statement toe aan de methode bestel() en test zowel het waar- als vals-geval.
Bijvoorbeeld: if (this.status.equals("In behandeling"))
Junit Test:
 */
=======
>>>>>>> Stashed changes
    @Test
    public void testConditionCoverage() {
        // Arrange
        Autosoort autosoort = new Autosoort( "Civic", "Honda",
                10, 1, 20);
        Autosoort autosoortLevering = new Autosoort( "SUV", "Tesla",
                10, 1, 20);
        Bestelling bestelling = new Bestelling(autosoort, 5);

        // Act
        bestelling.bestel("12/05/2025"); // verwachtte leverdatum
        Levering levering = bestelling.isGeleverd("24/05/2025",
                autosoortLevering, 4);

        // Assert
        // Controleer of de levering succesvol is gemaakt
        assertNull(levering);
    }
<<<<<<< Updated upstream



/*
3. Condition Coverage
Doel: Elk onderdeel van een samengestelde voorwaarde moet apart worden getest.
Testbasis: Voeg samengestelde logische condities toe en test elk onderdeel.
Bijvoorbeeld: if (this.status.equals("In behandeling") && hoeveelheid > 0)
Junit Test:
 */
    @Test
    public void testBestelConditionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Beide condities waar
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Een voorwaarde onwaar
        Bestelling bestelling2 = new Bestelling(1, "In behandeling", autosoort, 0, new Date(), null, new Date());
        bestelling2.bestel();
        assertEquals("Niet besteld", bestelling2.getStatus());  // Controleer nu op de nieuwe status
    }



    /*
    4. Condition/Decision Coverage
Doel: Zowel elke beslissing als elke voorwaarde moet volledig worden getest.
Testbasis: Test combinaties van voorwaarden en beslissingen.
Junit Test:
     */
    @Test
    public void testBestelConditionDecisionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Waar: status is "In behandeling" en hoeveelheid > 0
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Vals: status is "In behandeling" maar hoeveelheid <= 0
        Bestelling bestelling2 = new Bestelling(1, "In behandeling", autosoort, 0, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());

        // Vals: status is niet "In behandeling"
        Bestelling bestelling3 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling3.bestel();
        assertNotEquals("Besteld", bestelling3.getStatus());
    }



/*
5. Modified Condition/Decision Coverage (MC/DC)
Doel: Elke voorwaarde moet onafhankelijk het resultaat van de beslissing beïnvloeden.
Testbasis: We moeten ervoor zorgen dat elke conditie onafhankelijk kan beïnvloeden of een beslissing waar of onwaar is.
Junit Test:
 */
    @Test
    public void testBestelMCDC() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Waar: beide condities
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Test met conditie onafhankelijk (bv. hoeveelheden aanpassen)
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());
    }


/*
6. Multiple Condition Coverage
Doel: Test alle mogelijke combinaties van voorwaarden.
Testbasis: Maak testen met verschillende combinaties van voorwaarden.
Junit Test:
 */
    @Test
    public void testBestelMultipleConditionCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Combinatie 1: Beide waar
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Combinatie 2: Eerste onwaar, tweede waar
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());

        // Combinatie 3: Beide onwaar
        Bestelling bestelling3 = new Bestelling(1, "Geannuleerd", autosoort, 0, new Date(), null, new Date());
        bestelling3.bestel();
        assertNotEquals("Besteld", bestelling3.getStatus());
    }


    /*
    7. Path Coverage
Doel: Test elke mogelijke route door de code.
Testbasis: Test verschillende paden die de code kan nemen.
     */
    @Test
    public void testBestelPathCoverage() {
        Autosoort autosoort = new Autosoort(1, "Model X", "Tesla", 10, 1, 20);

        // Route 1: status is "In behandeling", hoeveelheid > 0
        Bestelling bestelling1 = new Bestelling(1, "In behandeling", autosoort, 2, new Date(), null, new Date());
        bestelling1.bestel();
        assertEquals("Besteld", bestelling1.getStatus());

        // Route 2: status is "Geannuleerd"
        Bestelling bestelling2 = new Bestelling(1, "Geannuleerd", autosoort, 2, new Date(), null, new Date());
        bestelling2.bestel();
        assertNotEquals("Besteld", bestelling2.getStatus());
    }

}
=======
}
>>>>>>> Stashed changes

package org.example.bestelling;

import org.example.autos.Autosoort;
import org.example.personeel.Factuur;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Vertegenwoordigt een bestelling van een specifiek autotype met details zoals status, hoeveelheid,
 * besteldatum en verwachte leverdatum.
 */
public class Bestelling {
    private String id;
    private String status;
    private Autosoort autosoort;
    private int hoeveelheid;
    private Date besteldatum;
    private Factuur factuur;
    private Date verwachteLeverdatum;
    private boolean isFinal;

    /**
     * Maakt een instantie van Bestelling met de opgegeven autotype en hoeveelheid.
     *
     * @param autosoort  het autotype dat besteld wordt
     * @param hoeveelheid de hoeveelheid van de bestelling
     */
    public Bestelling(Autosoort autosoort, int hoeveelheid) {
        this.id = UUID.randomUUID().toString(); // Genereer een UUID als String
        this.status = "In afwachting";
        this.autosoort = autosoort;
        this.hoeveelheid = hoeveelheid;
    }

    /**
     *  Wijzigt de status naar "Geannuleerd".
     */
    public void annuleer() {
        this.status = "Geannuleerd";
        this.isFinal = true;  // Mark the object as in the final state
    }

    /**
     * Plaatst de bestelling. Wijzigt de status naar "Besteld" als de voorwaarden voldoen.
     * Annuleert de bestelling als de hoeveelheid ongeldig is of de status niet in afwachting is.
     */
    public void bestel(String leverdatumString) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date leverdatum = formatter.parse(leverdatumString);

            // Gebruik leverdatum in je logica hier
            this.verwachteLeverdatum = leverdatum; // Stel de verwachte leverdatum in

            if (hoeveelheid > 0 && "In afwachting".equals(status)) {
                this.status = "Besteld";
                this.besteldatum = new Date(); // Stel de besteldatum in
            } else {
                annuleer();
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Ongeldig datumformaat. Gebruik DD/MM/YYYY.");
        }
    }

    /**
     * Geeft de huidige status van de bestelling terug.
     *
     * @return de status van de bestelling
     */
    public String getStatus() {
        return status;
    }

<<<<<<< Updated upstream
    public Levering isGeleverd() {
        return new Levering(this.id, new Date(), this);
=======
    /**
     * Stelt de status van de bestelling in.
     *
     * @param status de nieuwe status van de bestelling
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Markeert de bestelling als afgerond door de status aan te passen.
     */
    public void markeerAlsAfgerond() {
        this.status = "Afgerond";
    }

    /**
     * Geeft een Levering-object terug dat de levering van deze bestelling vertegenwoordigt,
     * mits aan de voorwaarden wordt voldaan. Markeert ook de bestelling als afgerond door de status aan te passen.
     *
     * @param leverdatumStr de datum waarop de levering plaatsvindt in het formaat dd/MM/yyyy
     * @return een Levering-object met de leverdatum en deze bestelling
     * @throws IllegalArgumentException als de levering niet kan worden geregistreerd
     */
    public Levering isGeleverd(String leverdatumStr, Autosoort autosoort, int hoeveelheid) {
        Date leverdatum;

        // Probeer de string om te zetten naar een Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            leverdatum = formatter.parse(leverdatumStr);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Ongeldig datumformaat, gebruik dd/MM/yyyy.");
        }

        // Controleer of de autosoort van de levering gelijk is aan de autosoort van de bestelling
        if (!this.autosoort.equals(autosoort)) {
            throw new IllegalArgumentException("De autosoort van de levering moet gelijk zijn aan de autosoort van de bestelling.");
        }

        // Controleer of het aantal auto's in de levering gelijk is aan het aantal auto's in de bestelling
        if (this.hoeveelheid != hoeveelheid) {
            throw new IllegalArgumentException("Het aantal auto's in de levering moet gelijk zijn aan het aantal auto's in de bestelling.");
        }

        // Bereken de verwachte leverdatum en de toegestane leverdatum
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.verwachteLeverdatum);
        calendar.add(Calendar.DAY_OF_MONTH, 10); // Voeg 10 dagen toe

        // Controleer of de leverdatum niet later is dan de toegestane leverdatum
        if (leverdatum.after(calendar.getTime())) {
            throw new IllegalArgumentException("De leverdatum mag niet later zijn dan 10 dagen na de verwachte leverdatum.");
        }

        // Controleer of de leverdatum niet in het verleden ligt
        Date huidigeDatum = new Date();
        if (leverdatum.before(huidigeDatum)) {
            throw new IllegalArgumentException("De leverdatum mag niet in het verleden liggen.");
        }

        this.markeerAlsAfgerond();

        // Maak en retourneer een nieuw Levering-object
        return new Levering(leverdatum, this);
    }

    /**
     * Controleert of de bestelling in de definitieve staat is.
     *
     * @return true als de bestelling definitief is, anders false
     */
    public boolean isFinal() {
        return isFinal;
>>>>>>> Stashed changes
    }
}
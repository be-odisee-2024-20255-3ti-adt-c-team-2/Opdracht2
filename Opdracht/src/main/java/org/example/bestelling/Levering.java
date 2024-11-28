package org.example.bestelling;

import java.util.Date;
import java.util.UUID;

/**
 * Vertegenwoordigt een levering van een bestelling met details zoals leverdatum en de bijbehorende bestelling.
 */
public class Levering {
    private String id; // This is a UUID as a String
    private Date leverdatum;
    private Bestelling bestelling;

    /**
     * Maakt een instantie van Levering met de opgegeven leverdatum en bijbehorende bestelling.
     *
     * @param leverdatum de datum waarop de levering plaatsvindt
     * @param bestelling de bestelling die geleverd wordt
     */
    public Levering(Date leverdatum, Bestelling bestelling) {
        this.id = UUID.randomUUID().toString(); // Generate a UUID as a String
        this.leverdatum = leverdatum;
        this.bestelling = bestelling;
    }

    /**
     * Geeft de unieke ID van de levering terug.
     *
     * @return de unieke ID van de levering
     */
    public String getId() { // Change return type to String
        return id; // Return the UUID as a String
    }

    /**
     * Geeft de leverdatum van de levering terug.
     *
     * @return de leverdatum van de levering
     */
    public Date getLeverdatum() {
        return leverdatum;
    }

    /**
     * Geeft de bijbehorende bestelling van de levering terug.
     *
     * @return de bestelling die geleverd wordt
     */
    public Bestelling getBestelling() {
        return bestelling;
    }
}
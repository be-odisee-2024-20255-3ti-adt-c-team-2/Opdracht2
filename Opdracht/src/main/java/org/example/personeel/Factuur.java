package org.example.personeel;

import java.util.UUID;

/**
 * Vertegenwoordigt een factuur met details over de transactie.
 */
public class Factuur {
    private int id;
    private String details;

    /**
     * Maakt een instantie van Factuur met de opgegeven details.
     *
     * @param details de details van de factuur
     */
    public Factuur(String details) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.details = details;
    }

    /**
     * Geeft de details van de factuur terug.
     *
     * @return de details van de factuur
     */
    public String getDetails() {
        return details;
    }

    /**
     * Geeft de unieke ID van de factuur terug.
     *
     * @return de unieke ID van de factuur
     */
    public int getId() {
        return id;
    }
}
package org.example.domein;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
/**
 * Vertegenwoordigt een factuur met details over de transactie.
 */
public class Factuur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long factuurId;

    private String details;

    /**
     * Maakt een instantie van Factuur met de opgegeven details.
     *
     * @param details de details van de factuur
     */
    public Factuur(String details) {
        this.details = details;
    }

    public Factuur(){

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

    public void setFactuurId(Long factuurId) {
        this.factuurId = factuurId;
    }

    public Long getFactuurId() {
        return factuurId;
    }
}
package org.example.autos;

import java.util.Date;
import java.util.UUID;

/**
 * Vertegenwoordigt een marktanalysevraag met details zoals status, datum en beschrijving.
 */
public class AnalyseMarktvraag {
    private int id;
    private String status;
    private Date datum;
    private String beschrijving;

    /**
     * Maakt een instantie van AnalyseMarktvraag met de opgegeven datum en beschrijving.
     *
     * @param datum       de datum van de analysevraag
     * @param beschrijving de beschrijving van de analysevraag
     */
    public AnalyseMarktvraag(Date datum, String beschrijving) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());  // Assign a unique identifier
        this.status = "Actueel";
        this.datum = datum;
        this.beschrijving = beschrijving;
    }

    /**
     * Verandert de status van de marktanalysevraag naar "Vervangen".
     */
    public void vervang() {
        this.status = "Vervangen";
    }
<<<<<<< Updated upstream
=======

    /**
     * Geeft de huidige status van de marktanalysevraag terug.
     *
     * @return de status van de marktanalysevraag
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Geeft de datum van de marktanalysevraag terug.
     *
     * @return de datum van de marktanalysevraag
     */
    public Date getDatum() {
        return this.datum;
    }

    /**
     * Geeft de beschrijving van de marktanalysevraag terug.
     *
     * @return de beschrijving van de marktanalysevraag
     */
    public String getBeschrijving() {
        return this.beschrijving;
    }

    /**
     * Geeft de unieke ID van de marktanalysevraag terug.
     *
     * @return de unieke ID van de marktanalysevraag
     */
    public int getId() {
        return this.id;
    }
>>>>>>> Stashed changes
}
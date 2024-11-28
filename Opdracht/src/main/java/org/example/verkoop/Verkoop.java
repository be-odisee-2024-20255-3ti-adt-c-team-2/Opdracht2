package org.example.verkoop;

import org.example.autos.Autosoort;
import org.example.personeel.BeerensMedewerker;
import org.example.personeel.Factuur;

import java.util.Date;
import java.util.UUID;

/**
 * Vertegenwoordigt een verkooptransactie met details zoals status, verkoopdatum, auto soort, factuur en verkoper.
 */
public class Verkoop {
    private int id;
    private String status;
    private Date verkoopDatum;
    private Autosoort autosoort;
    private Factuur factuur;
    private BeerensMedewerker verkoper;

    /**
     * Maakt een instantie van Verkoop met de opgegeven details.
     *
     * @param status       de huidige status van de verkoop
     * @param verkoopDatum de datum waarop de verkoop plaatsvond
     * @param autosoort    de soort auto die verkocht wordt
     * @param factuur      de factuur die bij de verkoop hoort
     * @param verkoper     de medewerker die de verkoop heeft uitgevoerd
     */
    public Verkoop(String status, Date verkoopDatum, Autosoort autosoort, Factuur factuur, BeerensMedewerker verkoper) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.status = status;
        this.verkoopDatum = verkoopDatum;
        this.autosoort = autosoort;
        this.factuur = factuur;
        this.verkoper = verkoper;
    }

    /**
     * Annuleert de verkoop door de status te wijzigen naar "Geannuleerd".
     */
    public void annuleer() {
        this.status = "Geannuleerd";
    }

    /**
     * Registreert de verkoop door de status te wijzigen naar "Geregistreerd".
     */
    public void registreer() {
        this.status = "Geregistreerd";
    }

    /**
     * Geeft de unieke ID van de verkoop terug.
     *
     * @return de unieke ID van de verkoop
     */
    public int getId() {
        return id;
    }

    /**
     * Geeft de huidige status van de verkoop terug.
     *
     * @return de status van de verkoop
     */
    public String getStatus() {
        return status;
    }

    /**
     * Geeft de verkoopdatum van de verkoop terug.
     *
     * @return de verkoopdatum
     */
    public Date getVerkoopDatum() {
        return verkoopDatum;
    }

    /**
     * Geeft de soort auto die verkocht wordt terug.
     *
     * @return de autosoort die verkocht wordt
     */
    public Autosoort getAutosoort() {
        return autosoort;
    }

    /**
     * Geeft de factuur die bij de verkoop hoort terug.
     *
     * @return de factuur van de verkoop
     */
    public Factuur getFactuur() {
        return factuur;
    }

    /**
     * Geeft de verkoper die de verkoop heeft uitgevoerd terug.
     *
     * @return de medewerker die de verkoop heeft uitgevoerd
     */
    public BeerensMedewerker getVerkoper() {
        return verkoper;
    }
}
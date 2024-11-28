package org.example.personeel;

import java.util.UUID;

/**
 * Vertegenwoordigt een medewerker van Beerens met details zoals naam, contactinformatie en functie.
 */
public class BeerensMedewerker {
    private int id;
    private String status;
    private String voornaam;
    private String achternaam;
    private String email;
    private String telefoonnummer;
    private BeerensMedewerkerFunctie functie;

    /**
     * Maakt een instantie van BeerensMedewerker met de opgegeven details.
     *
     * @param voornaam       de voornaam van de medewerker
     * @param achternaam     de achternaam van de medewerker
     * @param email          het emailadres van de medewerker
     * @param telefoonnummer  het telefoonnummer van de medewerker
     * @param functie        de functie van de medewerker
     */
    public BeerensMedewerker(String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie) {
        this.id = Integer.parseInt(UUID.randomUUID().toString());
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.functie = functie;
        this.status = "In dienst";
    }

    /**
     * Ontslaat de medewerker door de status te wijzigen naar "Ontslagen".
     */
    public void ontsla() {
        this.status = "Ontslagen";
    }

    /**
     * Neemt de medewerker in dienst door de status te wijzigen naar "In Dienst".
     */
    public void neemInDienst() {
        this.status = "In Dienst";
    }

    /**
     * Geeft de huidige status van de medewerker terug.
     *
     * @return de status van de medewerker
     */
    public String getStatus() {
        return status;
    }

    /**
     * Geeft de unieke ID van de medewerker terug.
     *
     * @return de unieke ID van de medewerker
     */
    public int getId() {
        return id;
    }

    /**
     * Geeft de voornaam van de medewerker terug.
     *
     * @return de voornaam van de medewerker
     */
    public String getVoornaam() {
        return voornaam;
    }

    /**
     * Geeft de achternaam van de medewerker terug.
     *
     * @return de achternaam van de medewerker
     */
    public String getAchternaam() {
        return achternaam;
    }

    /**
     * Geeft het emailadres van de medewerker terug.
     *
     * @return het emailadres van de medewerker
     */
    public String getEmail() {
        return email;
    }

    /**
     * Geeft het telefoonnummer van de medewerker terug.
     *
     * @return het telefoonnummer van de medewerker
     */
    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    /**
     * Geeft de functie van de medewerker terug.
     *
     * @return de functie van de medewerker
     */
    public BeerensMedewerkerFunctie getFunctie() {
        return functie;
    }
}
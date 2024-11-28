package org.example.autos;

import org.example.bestelling.Bestelling;

import java.util.UUID;

/**
 * Vertegenwoordigt een type auto (Autosoort) met details over de voorraadstatus,
 * marktanalyse en bestelmogelijkheden.
 */
public class Autosoort {
    private String id;
    private String status;
    private String naam;
    private String merk;
    private int huidigVoorraadniveau;
    private int minimumpeiler;
    private int maximumpeiler;
    private AnalyseMarktvraag marktvraag;

    /**
     * Maakt een instantie van Autosoort met de opgegeven details.
     *
     * @param naam                de naam van het autotype
     * @param merk                het merk van de auto
     * @param huidigVoorraadniveau het huidige voorraadniveau van dit autotype
     * @param minimumpeiler       de minimale voorraadgrens
     * @param maximumpeiler       de maximale voorraadgrens
     */
    public Autosoort(String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        this.id = UUID.randomUUID().toString();
        this.naam = naam;
        this.merk = merk;
        this.huidigVoorraadniveau = huidigVoorraadniveau;
        this.minimumpeiler = minimumpeiler;
        this.maximumpeiler = maximumpeiler;
        this.status = "Niet in bestelling";
    }

    /**
     * Merkt een bepaald aantal auto's als verkocht en past het huidige voorraadniveau aan.
     *
     * @param aantal het aantal verkochte auto's
     */
    public void isVerkocht(int aantal) {
        huidigVoorraadniveau -= aantal;
    }

    /**
     * Voegt een marktanalysevraag toe die gerelateerd is aan dit autotype.
     *
     * @param beschrijving de beschrijving van de marktanalysevraag
     */
    public void voegAnalyseMarktvraagToe(String beschrijving) {
        this.marktvraag = new AnalyseMarktvraag(new java.util.Date(), beschrijving);
    }

    /**
     * Maakt een nieuwe bestelling voor dit autotype met de opgegeven hoeveelheid.
     *
     * @param hoeveelheid de hoeveelheid die besteld moet worden
     * @return een nieuw Bestelling-object dat de bestelling vertegenwoordigt
     */
    public Bestelling voegBestellingToe(int hoeveelheid) {
        return new Bestelling(this, hoeveelheid);
    }


    /**
     * Merkt de huidige bestelling als afgerond.
     */
    public void bestellingAfgerond() {
        this.status = "Niet in bestelling";
    }
<<<<<<< Updated upstream
=======

    /**
     * Geeft het huidige voorraadniveau van dit autotype terug.
     *
     * @return het huidige voorraadniveau
     */
    public int getHuidigVoorraadniveau() {
        return this.huidigVoorraadniveau;
    }

    /**
     * Geeft de minimale voorraadgrens voor dit autotyper terug.
     *
     * @return de minimale voorraadgrens
     */
    public int getMinimumpeiler() {
        return this.minimumpeiler;
    }

    /**
     * Geeft de marktanalysevraag terug die geassocieerd is met dit autotype.
     *
     * @return de marktanalysevraag
     */
    public AnalyseMarktvraag getMarktvraag() {
        return this.marktvraag;
    }

    /**
     * Past het huidige voorraadniveau aan met de opgegeven nieuwe voorraadwaarde.
     *
     * @param nieuweVoorraad het nieuwe voorraadniveau
     */
    public void updateVoorraad(int nieuweVoorraad) {
        this.huidigVoorraadniveau = nieuweVoorraad;
    }

>>>>>>> Stashed changes
}
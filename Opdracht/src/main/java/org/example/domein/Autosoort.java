package org.example.domein;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
/**
 * Vertegenwoordigt een type auto (Autosoort) met details over de voorraadstatus,
 * marktanalyse en bestelmogelijkheden.
 */
public class Autosoort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long autosoortId;
    private String naam;
    private String merk;
    private int huidigVoorraadniveau;
    private int minimumpeiler;
    private int maximumpeiler;

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
        this.naam = naam;
        this.merk = merk;
        this.huidigVoorraadniveau = huidigVoorraadniveau;
        this.minimumpeiler = minimumpeiler;
        this.maximumpeiler = maximumpeiler;
    }

    public Autosoort() {

    }

    /**
     * Merkt een bepaald aantal auto's als verkocht en past het huidige voorraadniveau aan.
     *
     * @param aantal het aantal verkochte auto's
     */
    public void isVerkocht(int aantal) {
        huidigVoorraadniveau -= aantal;
    }


    public void setAutosoortId(long autosoortId) {
        this.autosoortId = autosoortId;
    }

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
     * Past het huidige voorraadniveau aan met de opgegeven nieuwe voorraadwaarde.
     *
     * @param nieuweVoorraad het nieuwe voorraadniveau
     */
    public void updateVoorraad(int nieuweVoorraad) {
        this.huidigVoorraadniveau = nieuweVoorraad;
    }

    public Long getId(){
        return autosoortId;
    }
}
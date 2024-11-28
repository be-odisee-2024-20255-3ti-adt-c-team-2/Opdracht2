package org.example;

import org.example.domein.Autosoort;
import org.example.domein.Bestelling;
import org.example.domein.Factuur;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Maak een nieuwe autosoort aan
        Autosoort autosoort = new Autosoort("Model X", "Tesla", 10, 1, 20);

        // Maak een nieuwe bestelling
        Factuur factuur = new Factuur("Factuur voor bestelling 1");
        Bestelling bestelling = new Bestelling(autosoort, 2);

        // Verwerk de bestelling
        bestelling.bestel("14/09/2025");
        System.out.println("Bestelling is geplaatst!");

        // Controleer of de bestelling geleverd is
        /*
        if (bestelling.isGeleverd() != null) {
            System.out.println("De bestelling is geleverd!");
        }*/
    }
}
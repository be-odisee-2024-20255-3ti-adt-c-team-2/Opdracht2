package org.example.service;

import org.example.service.AutosoortService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AutosoortServiceImpl implements AutosoortService {

    private final Map<Long, Autosoort> autosoorten = new HashMap<>();
    private long currentId = 1;

    @Override
    public long addAutosoort(String naam, String merk, int huidigeVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        Autosoort autosoort = new Autosoort(naam, merk, huidigeVoorraadniveau, minimumpeiler, maximumpeiler);
        autosoorten.put(currentId, autosoort);
        return currentId++;
    }

    @Override
    public int countKnownAutosoorten() {
        return autosoorten.size();
    }

    @Override
    public void forgetKnownAutosoorten() {
        autosoorten.clear();
    }

    @Override
    public List<String> showListOfAutosoorten() {
        List<String> autosoortenList = new ArrayList<>();
        for (Autosoort autosoort : autosoorten.values()) {
            autosoortenList.add(autosoort.getNaam() + ", " + autosoort.getHuidigeVoorraadniveau());
        }
        return autosoortenList;
    }

    @Override
    public String searchAutosoortById(long id) {
        Autosoort autosoort = autosoorten.get(id);
        if (autosoort != null) {
            return autosoort.toString();
        }
        return "Autosoort niet gevonden";
    }

    @Override
    public String searchAutosoortByNameAndBrand(String naamMerk) {
        for (Autosoort autosoort : autosoorten.values()) {
            if (autosoort.getNaam().equals(naamMerk) || autosoort.getMerk().equals(naamMerk)) {
                return autosoort.toString();
            }
        }
        return "Autosoort niet gevonden";
    }

    // Inner class representing the Autosoort entity
    private static class Autosoort {
        private final String naam;
        private final String merk;
        private final int huidigeVoorraadniveau;
        private final int minimumpeiler;
        private final int maximumpeiler;

        public Autosoort(String naam, String merk, int huidigeVoorraadniveau, int minimumpeiler, int maximumpeiler) {
            this.naam = naam;
            this.merk = merk;
            this.huidigeVoorraadniveau = huidigeVoorraadniveau;
            this.minimumpeiler = minimumpeiler;
            this.maximumpeiler = maximumpeiler;
        }

        public String getNaam() {
            return naam;
        }

        public String getMerk() {
            return merk;
        }

        public int getHuidigeVoorraadniveau() {
            return huidigeVoorraadniveau;
        }

        @Override
        public String toString() {
            return String.format("Naam: %s, Merk: %s, Voorraadniveau: %d", naam, merk, huidigeVoorraadniveau);
        }
    }
}
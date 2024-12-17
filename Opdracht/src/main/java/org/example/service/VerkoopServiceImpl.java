package org.example.service;

import org.example.domein.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VerkoopServiceImpl implements VerkoopService {

    private final Map<Long, Verkoop> verkopen = new HashMap<>();
    private final Map<Long, Factuur> facturen = new HashMap<>();
    private final Map<Long, BeerensMedewerker> medewerkers = new HashMap<>();
    private long currentId = 1;

    @Override
    public Long addFactuur(String nummer) {
        facturen.put(currentId, new Factuur(nummer));
        return currentId++;
    }

    @Override
    public List<Factuur> getAllFacturen() {
        return new ArrayList<>(facturen.values());
    }

    @Override
    public Long addMedewerker(String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie) {
        medewerkers.put(currentId, new BeerensMedewerker(voornaam, achternaam, email, telefoonnummer, BeerensMedewerkerFunctie.VERKOPER));
        return currentId++;
    }

    @Override
    public List<BeerensMedewerker> getAllMedewerkers() {
        return new ArrayList<>(medewerkers.values());
    }

    @Override
    public List<Verkoop> findAllVerkopen() {
        return new ArrayList<>(verkopen.values());
    }

    @Override
    public long addVerkoop(Long autosoortId, Long factuurId, Long medewerkerId) {
        // Dummy data voor Autosoort, Factuur, en Medewerker (vervangen met echte DB calls)
        Autosoort autosoort = new Autosoort( "NaamAutosoort", "Merk", 10, 1, 20);
        Factuur factuur = new Factuur( "FACT12345");
        BeerensMedewerker medewerker = new BeerensMedewerker( "Voornaam", "Achternaam", "email@test.com", "0123456789", BeerensMedewerkerFunctie.VERKOPER);

        // Maak een nieuwe verkoop aan
        Verkoop verkoop = new Verkoop("Geregistreerd", new java.util.Date(), autosoort, factuur, medewerker);
        verkopen.put(currentId, verkoop);
        System.out.println("Verkoop created with id: " + currentId);
        return currentId++;
    }

    @Override
    public void deleteAllVerkopen() {
        verkopen.clear();
        System.out.println("Alle verkopen zijn verwijderd.");
    }

    @Override
    public String searchVerkoopById(long id) {
        Verkoop verkoop = verkopen.get(id);
        if (verkoop != null) {
            return verkoop.toString();
        }
        return "Verkoop niet gevonden";
    }

    @Override
    public int countKnownVerkopen() {
        return verkopen.size();
    }

    @Override
    public List<String> showListOfVerkopen() {
        List<String> verkoopList = new ArrayList<>();
        for (Verkoop verkoop : verkopen.values()) {
            verkoopList.add("ID: " + verkoop.getId() + ", Autosoort: " + verkoop.getAutosoort().getNaam()
                    + ", Factuur: " + verkoop.getFactuur().getDetails()
                    + ", Verkoper: " + verkoop.getVerkoper().getVoornaam());
        }
        return verkoopList;
    }

    @Override
    public void forgetKnownVerkopen() {
        verkopen.clear();
        System.out.println("Alle gekende verkopen zijn vergeten.");
    }
}

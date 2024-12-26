package org.example.service;

import org.example.dao.AutosoortRepository;
import org.example.domein.Autosoort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AutosoortServiceImpl implements AutosoortService{

    private final AutosoortRepository autosoortRepository;
    private final Map<Long, Autosoort> autosoorten = new HashMap<>();
    private long currentId = 1;

    public AutosoortServiceImpl(AutosoortRepository autosoortRepository){
        this.autosoortRepository = autosoortRepository;
    }


    @Override
    public List<Autosoort> findAllAutosoorten() {
        return autosoortRepository.findAll();
    }

    @Override
    public void saveAutosoort(Autosoort autosoort) {
        autosoortRepository.save(autosoort);
    }

    @Override
    public List<Autosoort> getListOfAutosoorts() {
        return autosoortRepository.findAll().stream().toList();
    }

    @Override
    public String searchAutosoortByNaam(String naam) {

        System.out.println("Zoeken naar autosoort met naam "+ naam);
        Autosoort deAuto = autosoortRepository.findByNaam(naam).get();
        if (deAuto != null){
            return deAuto.getNaam() + " " + deAuto.getMerk();
        } else {
            return null;
        }
    }

    @Override
    public Autosoort getAutosoortByNaam(String naam) {
        System.out.println("Zoeken naar autosoort met naam "+ naam);
        return autosoortRepository.findByNaam(naam).orElse(null);
    }

    @Override
    public void deleteAllAutosoorts() {
        System.out.println("Deleting all known autosoorts");
        autosoortRepository.deleteAll();
    }

    @Override
    public long addAutosoortD(String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        Autosoort autosoort = new Autosoort(naam, merk, huidigVoorraadniveau, minimumpeiler, maximumpeiler);
        autosoortRepository.save(autosoort);
        System.out.println("Autosoort created with id "+autosoort.getId()+" and naam + merk " + autosoort.getNaam() + "  " + autosoort.getMerk());
        return autosoort.getId();
    }

    @Override
    public long addAutosoortM(String naam, String merk, int huidigeVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        Autosoort autosoort = new Autosoort(naam, merk, huidigeVoorraadniveau, minimumpeiler, maximumpeiler);
        autosoorten.put(currentId, autosoort);
        return currentId++;
    }

    @Override
    public int countKnownAutosoorten() {
        return (int) autosoortRepository.count();
    }

    @Override
    public void forgetKnownAutosoorten() {
        autosoorten.clear();
    }

    @Override
    public List<String> showListOfAutosoorten() {
        List<String> autosoortenList = new ArrayList<>();
        for (Autosoort autosoort : autosoorten.values()) {
            autosoortenList.add(autosoort.getNaam() + ", " + autosoort.getHuidigVoorraadniveau());
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
}
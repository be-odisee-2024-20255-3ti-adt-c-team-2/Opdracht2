package org.example.service;

import org.example.dao.AutosoortRepository;
import org.example.domein.Autosoort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutosoortServiceImpl implements AutosoortService{

    private final AutosoortRepository autosoortRepository;

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
    public Autosoort findAutosoortById(Long id) {
        return null;
    }

    @Override
    public Autosoort saveAutosoort(String merk, String model) {
        return null;
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
    public long addAutosoort(String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler) {
        Autosoort autosoort = new Autosoort(naam, merk, huidigVoorraadniveau, minimumpeiler, maximumpeiler);
        autosoortRepository.save(autosoort);
        System.out.println("Autosoort created with id "+autosoort.getId()+" and naam + merk " + autosoort.getNaam() + "  " + autosoort.getMerk());
        return autosoort.getId();
    }
}

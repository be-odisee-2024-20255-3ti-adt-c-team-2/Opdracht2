package org.example.service;

import org.example.domein.Autosoort;

import java.util.List;

public interface AutosoortService {

    // Autosoorten
    List<Autosoort> findAllAutosoorten();
    void saveAutosoort(Autosoort autosoort);
    Autosoort findAutosoortById(Long id);
    Autosoort saveAutosoort(String merk, String model);

    List<Autosoort> getListOfAutosoorts();

    public String searchAutosoortByNaam(String naam);

    Autosoort getAutosoortByNaam(String naam);

    void deleteAllAutosoorts();

    long addAutosoort(String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler);
}

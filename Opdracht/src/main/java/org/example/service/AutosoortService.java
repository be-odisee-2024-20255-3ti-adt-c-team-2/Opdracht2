package org.example.service;

import org.example.domein.Autosoort;

import java.util.List;

public interface AutosoortService {

    // Autosoorten
    List<Autosoort> findAllAutosoorten();

    void saveAutosoort(Autosoort autosoort);

    List<Autosoort> getListOfAutosoorts();

    public String searchAutosoortByNaam(String naam);

    Autosoort getAutosoortByNaam(String naam);

    void deleteAllAutosoorts();

    long addAutosoortD(String naam, String merk, int huidigVoorraadniveau, int minimumpeiler, int maximumpeiler);
    long addAutosoortM(String naam, String merk, int huidigeVoorraadniveau, int minimumpeiler, int maximumpeiler);


    int countKnownAutosoorten();

    void forgetKnownAutosoorten();

    List<String> showListOfAutosoorten();

    String searchAutosoortById(long id);

    String searchAutosoortByNameAndBrand(String naamMerk);
}
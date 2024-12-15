package org.example.service;

import java.util.List;

public interface AutosoortService {
    long addAutosoort(String naam, String merk, int huidigeVoorraadniveau, int minimumpeiler, int maximumpeiler);

    int countKnownAutosoorten();

    void forgetKnownAutosoorten();

    List<String> showListOfAutosoorten();

    String searchAutosoortById(long id);

    String searchAutosoortByNameAndBrand(String naamMerk);
}
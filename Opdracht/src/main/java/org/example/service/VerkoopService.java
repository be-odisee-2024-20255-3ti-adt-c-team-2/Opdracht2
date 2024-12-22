package org.example.service;

import org.example.domein.*;

import java.util.List;

public interface VerkoopService {

    Long addFactuur(String nummer);
    List<Factuur> getAllFacturen();

    Long addMedewerker(String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie);

    List<BeerensMedewerker> getAllMedewerkers();

    List<Verkoop> findAllVerkopen();

    long addVerkoop(Long autosoortId, Long factuurId, Long medewerkerId);

    void deleteAllVerkopen();

    String searchVerkoopById(long id);

    int countKnownVerkopen();

    List<String> showListOfVerkopen();

    void forgetKnownVerkopen();
}

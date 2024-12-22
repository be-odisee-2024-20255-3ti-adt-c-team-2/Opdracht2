package org.example.controller;

import org.example.domein.BeerensMedewerker;
import org.example.domein.BeerensMedewerkerFunctie;
import org.example.domein.Factuur;
import org.example.domein.Verkoop;
import org.example.service.VerkoopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/verkopen")
public class VerkoopController {

    private final VerkoopService verkoopService;

    @Autowired
    public VerkoopController(VerkoopService verkoopService) {
        this.verkoopService = verkoopService;
    }


    // Factuur
    @PostMapping("/facturen")
    public ResponseEntity<Long> addFactuur(@RequestParam String nummer) {
        return ResponseEntity.ok(verkoopService.addFactuur(nummer));
    }

    @GetMapping("/facturen")
    public ResponseEntity<List<Factuur>> getFacturen() {
        return ResponseEntity.ok(verkoopService.getAllFacturen());
    }

    // Medewerker
    @PostMapping("/medewerkers")
    public ResponseEntity<Long> addMedewerker(@RequestParam String voornaam, String achternaam, String email, String telefoonnummer, BeerensMedewerkerFunctie functie) {
        return ResponseEntity.ok(verkoopService.addMedewerker(voornaam, achternaam, email, telefoonnummer, functie));
    }

    @GetMapping("/medewerkers")
    public ResponseEntity<List<BeerensMedewerker>> getMedewerkers() {
        return ResponseEntity.ok(verkoopService.getAllMedewerkers());
    }

    // Verkoop
    @PostMapping("/verkopen")
    public ResponseEntity<Long> addVerkoop(@RequestParam Long autosoortId, @RequestParam Long factuurId,
                                           @RequestParam Long medewerkerId) {
        return ResponseEntity.ok(verkoopService.addVerkoop(autosoortId, factuurId, medewerkerId));
    }

    @GetMapping("/verkopen")
    public ResponseEntity<List<Verkoop>> getVerkopen() {
        return ResponseEntity.ok(verkoopService.findAllVerkopen());
    }

    @DeleteMapping("/verkopen")
    public ResponseEntity<Void> deleteVerkopen() {
        verkoopService.deleteAllVerkopen();
        return ResponseEntity.noContent().build();
    }

}

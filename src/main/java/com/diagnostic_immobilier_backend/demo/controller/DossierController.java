package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.service.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dossiers")
public class DossierController {

    @Autowired
    private DossierService dossierService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Dossier> createDossier(@RequestBody Dossier dossier) {
        Dossier savedDossier = dossierService.createDossier(dossier);
        return new ResponseEntity<>(savedDossier, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/getall")
    public ResponseEntity<List<Dossier>> getAllDossiers() {
        List<Dossier> dossiers = dossierService.getAllDossiers();
        return new ResponseEntity<>(dossiers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> getDossierById(@PathVariable long id) {
        Optional<Dossier> dossier = dossierService.getDossierById(id);
        return dossier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Dossier> updateDossier(@PathVariable long id, @RequestBody Dossier dossier) {
        dossier.setId((int) id);
        Dossier updatedDossier = dossierService.updateDossier(dossier);
        return new ResponseEntity<>(updatedDossier, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDossier(@PathVariable long id) {
        dossierService.deleteDossier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import com.diagnostic_immobilier_backend.demo.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<Rapport> createRapport(@RequestBody Rapport rapport) {
        Rapport createdRapport = rapportService.createRapport(rapport);
        return new ResponseEntity<>(createdRapport, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/getall")
    public ResponseEntity<List<Rapport>> getAllRapports() {
        List<Rapport> rapports = rapportService.getAllRapports();
        return new ResponseEntity<>(rapports, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable("id") Integer id) {
        Optional<Rapport> rapport = rapportService.getRapportById(id);
        return rapport.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable("id") Integer id, @RequestBody Rapport rapport) {
        if (!rapportService.getRapportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rapport.setId(id); // Assurez-vous que l'ID est bien défini pour la mise à jour
        Rapport updatedRapport = rapportService.updateRapport(rapport);
        return new ResponseEntity<>(updatedRapport, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable("id") Integer id) {
        if (!rapportService.getRapportById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }
}

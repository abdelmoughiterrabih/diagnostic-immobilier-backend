package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.DTO.RapportDTO;
import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import com.diagnostic_immobilier_backend.demo.service.RapportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rapports")
public class RapportController {

    @Autowired
    private RapportService rapportService;

    // Créer un nouveau rapport
    @PostMapping("/create")
    public RapportDTO createRapport(@RequestBody RapportDTO rapportDTO) {
        return rapportService.createRapport(rapportDTO);
    }

    // Obtenir tous les rapports
    @GetMapping("/getall")
    public List<Rapport> getAllRapports() {
        return rapportService.getAllRapports();
    }

    // Obtenir un rapport par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Rapport> getRapportById(@PathVariable Long id) {
        Rapport rapport = rapportService.getRapportById(id).orElseThrow(() -> new RuntimeException("Rapport not found"));
        return ResponseEntity.ok(rapport);
    }

    // Mettre à jour un rapport
    @PutMapping("/{id}")
    public ResponseEntity<Rapport> updateRapport(@PathVariable Long id, @RequestBody Rapport rapportDetails) {
        Rapport updatedRapport = rapportService.updateRapport(id, rapportDetails);
        return ResponseEntity.ok(updatedRapport);
    }

    // Supprimer un rapport
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRapport(@PathVariable Long id) {
        rapportService.deleteRapport(id);
        return ResponseEntity.noContent().build();
    }
}

package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.DTO.FactureDTO;
import com.diagnostic_immobilier_backend.demo.service.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    @Autowired
    private FactureService factureService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<FactureDTO> createFacture(@RequestBody FactureDTO factureDTO) {
        FactureDTO savedFactureDTO = factureService.createFacture(factureDTO);
        return new ResponseEntity<>(savedFactureDTO, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/getall")
    public ResponseEntity<List<FactureDTO>> getAllFactures() {
        List<FactureDTO> factures = factureService.getAllFactures();
        return new ResponseEntity<>(factures, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FactureDTO> getFactureById(@PathVariable long id) {
        Optional<FactureDTO> factureDTO = factureService.getFactureById(id);
        return factureDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<FactureDTO> updateFacture(@PathVariable long id, @RequestBody FactureDTO factureDTO) {
        FactureDTO updatedFactureDTO = factureService.updateFacture(id, factureDTO);
        return new ResponseEntity<>(updatedFactureDTO, HttpStatus.OK);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable long id) {
        factureService.deleteFacture(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

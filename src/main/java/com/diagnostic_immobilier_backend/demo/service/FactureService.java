package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Facture;
import com.diagnostic_immobilier_backend.demo.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    // Create
    public Facture createFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    // Read
    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Optional<Facture> getFactureById(long id) {
        return factureRepository.findById((int) id);
    }

    // Update
    public Facture updateFacture(Facture facture) {
        return factureRepository.save(facture);
    }

    // Delete
    public void deleteFacture(long id) {
        factureRepository.deleteById((int) id);
    }
}
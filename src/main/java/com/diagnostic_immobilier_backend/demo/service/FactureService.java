package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.DTO.FactureDTO;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.entity.Facture;
import com.diagnostic_immobilier_backend.demo.repository.DossierRepository;
import com.diagnostic_immobilier_backend.demo.repository.FactureRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private DossierRepository dossierRepository;

    // Méthode pour ajouter une nouvelle facture
    public FactureDTO createFacture(FactureDTO factureDTO) {
        Long dossierId = factureDTO.getDossier();
        if (dossierId == null) {
            throw new IllegalArgumentException("The given dossier id must not be null");
        }

        Optional<Dossier> dossierOpt = dossierRepository.findById(dossierId);
        if (dossierOpt.isPresent()) {
            Dossier dossier = dossierOpt.get();
            Facture facture = this.toEntity(factureDTO);
            facture.setDossier(dossier); // assuming facture should be linked to dossier

            Facture savedFacture = factureRepository.save(facture);
            return FactureDTO.toDTO(savedFacture);
        } else {
            throw new EntityNotFoundException("Dossier not found with id " + dossierId);
        }
    }

    // Méthode pour obtenir toutes les factures
    public List<FactureDTO> getAllFactures() {
        List<Facture> factures = factureRepository.findAll();
        return factures.stream().map(FactureDTO::toDTO).toList();
    }

    // Méthode pour obtenir une facture par son ID
    public Optional<FactureDTO> getFactureById(Long id) {
        Optional<Facture> factureOpt = factureRepository.findById(id);
        return factureOpt.map(FactureDTO::toDTO);
    }

    // Méthode pour mettre à jour une facture
    public FactureDTO updateFacture(Long id, FactureDTO factureDTO) {
        Facture facture = factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
        facture.setNumero_facture(factureDTO.getNumero_facture());
        facture.setDate_facture(factureDTO.getDate_facture());
        facture.setMontant_facture(factureDTO.getMontant_facture());
        facture.setDescription(factureDTO.getDescription());
        facture.setDossier(dossierRepository.findById(factureDTO.getDossier()).orElse(null)); // Mise à jour de la relation Dossier

        Facture updatedFacture = factureRepository.save(facture);
        return FactureDTO.toDTO(updatedFacture);
    }

    // Méthode pour supprimer une facture
    public void deleteFacture(Long id) {
        Facture facture = factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
        factureRepository.delete(facture);
    }

    public Facture toEntity(FactureDTO factureDTO) {
        return new Facture(
                factureDTO.getId() != null ? factureDTO.getId() : 0L, // Handle null id
                factureDTO.getNumero_facture(),
                factureDTO.getDate_facture(),
                factureDTO.getMontant_facture(),
                factureDTO.getDescription(),
                dossierRepository.findById(factureDTO.getDossier()).orElse(null)
        );
    }
}

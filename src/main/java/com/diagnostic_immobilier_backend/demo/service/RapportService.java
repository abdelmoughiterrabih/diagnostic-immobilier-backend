package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import com.diagnostic_immobilier_backend.demo.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    // Méthode pour ajouter un nouveau rapport
    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    // Méthode pour obtenir tous les rapports
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    // Méthode pour obtenir un rapport par son ID
    public Optional<Rapport> getRapportById(Long id) {
        return rapportRepository.findById(id);
    }

    // Méthode pour mettre à jour un rapport
    public Rapport updateRapport(Long id, Rapport rapportDetails) {
        Rapport rapport = rapportRepository.findById(id).orElseThrow(() -> new RuntimeException("Rapport not found"));
        rapport.setDate(rapportDetails.getDate());
        rapport.setResultat_diagnostic(rapportDetails.getResultat_diagnostic());
        rapport.setEstimation_prix(rapportDetails.getEstimation_prix());
        rapport.setAddresse_bien(rapportDetails.getAddresse_bien());
        rapport.setType_bien(rapportDetails.getType_bien());
        rapport.setDescription_bien(rapportDetails.getDescription_bien());
        rapport.setDossier(rapportDetails.getDossier()); // Mise à jour de la relation Dossier
        return rapportRepository.save(rapport);
    }

    // Méthode pour supprimer un rapport
    public void deleteRapport(Long id) {
        Rapport rapport = rapportRepository.findById(id).orElseThrow(() -> new RuntimeException("Rapport not found"));
        rapportRepository.delete(rapport);
    }
}

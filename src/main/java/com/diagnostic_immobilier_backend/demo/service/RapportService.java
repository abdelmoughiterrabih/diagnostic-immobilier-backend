package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.DTO.RapportDTO;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import com.diagnostic_immobilier_backend.demo.repository.DossierRepository;
import com.diagnostic_immobilier_backend.demo.repository.RapportRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;
    @Autowired
private DossierRepository dossierRepository;
    // Méthode pour ajouter un nouveau rapport
    public RapportDTO createRapport(RapportDTO rapportDTO) {
        Long dossierId = rapportDTO.getDossier();
        if (dossierId == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }

        Optional<Dossier> dossierOpt = dossierRepository.findById(dossierId);
        if (dossierOpt.isPresent()) {
            Dossier dossier = dossierOpt.get();
            Rapport rapport = this.toEntity(rapportDTO);
            rapport.setDossier(dossier); // assuming rapport should be linked to dossier

            rapportRepository.save(rapport);
            return rapportDTO;
        } else {
            throw new EntityNotFoundException("Dossier not found with id " + dossierId);
        }
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
    public Rapport toEntity(RapportDTO rapportDTO) {

        return new Rapport(
                rapportDTO.getId(),
                rapportDTO.getDate(),
                rapportDTO.getResultat_diagnostic(),
                rapportDTO.getEstimation_prix(),
                rapportDTO.getAddresse_bien(),
                rapportDTO.getType_bien(),
                rapportDTO.getDescription_bien(),
                dossierRepository.findById(rapportDTO.getDossier()).get()
        );




    }
}

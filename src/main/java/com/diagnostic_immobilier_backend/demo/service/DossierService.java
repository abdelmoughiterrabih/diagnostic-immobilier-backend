package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Client;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.repository.DossierRepository;
import com.diagnostic_immobilier_backend.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private ClientRepository clientRepository;

    // Create
    public Dossier createDossier(Dossier dossier) {
        if (dossier.getClient() != null) {
            Optional<Client> client = clientRepository.findById(dossier.getClient().getId());
            client.ifPresent(dossier::setClient);
        }
        if (dossier.getRapport() != null) {
            dossier.getRapport().setDossier(dossier);
        }
        if (dossier.getFacture() != null) {
            dossier.getFacture().setDossier(dossier);
        }
        return dossierRepository.save(dossier);
    }

    // Read
    public List<Dossier> getAllDossiers() {
        return dossierRepository.findAll();
    }

    public Optional<Dossier> getDossierById(long id) {
        return dossierRepository.findById((int) id);
    }

    // Update
    public Dossier updateDossier(Dossier dossier) {
        if (dossier.getClient() != null) {
            Optional<Client> client = clientRepository.findById(dossier.getClient().getId());
            client.ifPresent(dossier::setClient);
        }
        if (dossier.getRapport() != null) {
            dossier.getRapport().setDossier(dossier);
        }
        if (dossier.getFacture() != null) {
            dossier.getFacture().setDossier(dossier);
        }
        return dossierRepository.save(dossier);
    }

    // Delete
    public void deleteDossier(long id) {
        dossierRepository.deleteById((int) id);
    }
}

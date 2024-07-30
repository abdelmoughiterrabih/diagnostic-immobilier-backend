package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Client;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.repository.DossierRepository;
import com.diagnostic_immobilier_backend.demo.repository.ClientRepository;  // Ajoutez cette ligne
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {

    @Autowired
    private DossierRepository dossierrepository;

    @Autowired
    private ClientRepository clientRepository;  // Ajoutez cette ligne

    // Create
    public Dossier createDossier(Dossier dossier){
        if (dossier.getClient() != null) {
            Optional<Client> client = clientRepository.findById(dossier.getClient().getId());
            client.ifPresent(dossier::setClient);
        }
        return dossierrepository.save(dossier);
    }

    // Read
    public List<Dossier> getAllDossiers() {
        return dossierrepository.findAll();
    }

    public Optional<Dossier> getDossierById(long id) {
        return dossierrepository.findById((int) id);
    }

    // Update
    public Dossier updateDossier(Dossier dossier) {
        if (dossier.getClient() != null) {
            Optional<Client> client = clientRepository.findById(dossier.getClient().getId());
            client.ifPresent(dossier::setClient);
        }
        return dossierrepository.save(dossier);
    }

    // Delete
    public void deleteDossier(long id) {
        dossierrepository.deleteById((int) id);
    }
}

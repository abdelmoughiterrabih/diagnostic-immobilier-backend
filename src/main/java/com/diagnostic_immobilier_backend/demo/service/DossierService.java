package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Client;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierService {
    @Autowired
    private DossierRepository dossierrepository;
    //create
    public Dossier createDossier(Dossier dossier){

        return dossierrepository.save(dossier);
    }
    //read
public List<Dossier> getAllDossiers(){
        return dossierrepository.findAll();
}
    public Optional<Dossier> getDossierById(long id) {
        return dossierrepository.findById((int) id);
    }
    //update
    public Dossier updateDossier(Dossier dossier) {
        return dossierrepository.save(dossier);
    }
    public void deleteDossier(long id) {
        dossierrepository.deleteById((int) id);
    }
}

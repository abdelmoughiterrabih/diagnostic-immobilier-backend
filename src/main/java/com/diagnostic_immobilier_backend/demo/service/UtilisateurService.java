package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Utilisateur;
import com.diagnostic_immobilier_backend.demo.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Create
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Read
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<Utilisateur> getUtilisateurById(long id) {
        return utilisateurRepository.findById((int) id);
    }

    // Update
    public Utilisateur updateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Delete
    public void deleteUtilisateur(long id) {
        utilisateurRepository.deleteById((int) id);
    }
}
package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Utilisateur;
import com.diagnostic_immobilier_backend.demo.repository.UserRepository;
import com.diagnostic_immobilier_backend.demo.repository.UtilisateurRepository;
import com.diagnostic_immobilier_backend.demo.usermodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UserRepository utilisateurRepository;

    // Create
    public User createUtilisateur(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Read
    public List<User> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Optional<User> getUtilisateurById(long id) {
        return utilisateurRepository.findById(id);
    }

    // Update
    public User updateUtilisateur(User utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    // Delete
    public void deleteUtilisateur(long id) {
        utilisateurRepository.deleteById( id);
    }
}
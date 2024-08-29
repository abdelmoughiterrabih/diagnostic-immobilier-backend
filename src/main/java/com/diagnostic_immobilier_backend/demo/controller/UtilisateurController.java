package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.entity.Utilisateur;
import com.diagnostic_immobilier_backend.demo.service.UtilisateurService;
import com.diagnostic_immobilier_backend.demo.usermodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Create
    @PostMapping("/create")
    public ResponseEntity<User> createUtilisateur(@RequestBody User utilisateur) {
        User createdUtilisateur = utilisateurService.createUtilisateur(utilisateur);
        return new ResponseEntity<>(createdUtilisateur, HttpStatus.CREATED);
    }

    // Read
    @GetMapping("/getall")
    public ResponseEntity<List<User>> getAllUtilisateurs() {
        List<User> utilisateurs = utilisateurService.getAllUtilisateurs();
        return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUtilisateurById(@PathVariable long id) {
        Optional<User> utilisateur = utilisateurService.getUtilisateurById(id);
        return utilisateur.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUtilisateur(@PathVariable long id, @RequestBody User utilisateur) {
        Optional<User> existingUtilisateur = utilisateurService.getUtilisateurById(id);
        if (existingUtilisateur.isPresent()) {
            utilisateur.setId(id);
            User updatedUtilisateur = utilisateurService.updateUtilisateur(utilisateur);
            return new ResponseEntity<>(updatedUtilisateur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable long id) {
        Optional<User> utilisateur = utilisateurService.getUtilisateurById(id);
        if (utilisateur.isPresent()) {
            utilisateurService.deleteUtilisateur(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
package com.diagnostic_immobilier_backend.demo.controller;

import com.diagnostic_immobilier_backend.demo.model.FactureEmailRequest;
import com.diagnostic_immobilier_backend.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/send-facture-email")
    public ResponseEntity<String> sendFactureEmail(@RequestBody FactureEmailRequest request) {
        try {
            // Appeler le service d'email pour envoyer l'email avec les données reçues
            emailService.sendFactureEmail(request);
            return ResponseEntity.ok("Email envoyé avec succès à " + request.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors de l'envoi de l'email");
        }
    }
}

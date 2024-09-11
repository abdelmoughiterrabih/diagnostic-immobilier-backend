package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.model.FactureEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;



    public void sendFactureEmail(FactureEmailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(request.getEmail());
        message.setSubject(request.getObjet());

        // Construire le message avec les données de la facture
        String emailBody = request.getMessage() + "\n\nDétails de la Facture :\n" +
                "Numéro de la facture : " + request.getFacture().getNumero_facture() + "\n" +
                "Montant : " + request.getFacture().getMontant_facture() + " MAD\n" +
                "Description : " + request.getFacture().getDescription() + "\n" +
                "Date d'émission : " + request.getFacture().getDate_facture();
        message.setText(emailBody);

        javaMailSender.send(message);
    }
}

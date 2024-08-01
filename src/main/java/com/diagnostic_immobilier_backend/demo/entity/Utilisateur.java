package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

      private String nom_utilisateur;

    private String address_email;

    private String  mot_passe;

    private String role ;

}



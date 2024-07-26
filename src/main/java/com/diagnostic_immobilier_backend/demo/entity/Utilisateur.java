package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
      private String nom_utilisateur;
    @Column
    private String address_email;
    @Column
    private String  mot_passe;
    public Utilisateur(){
    }
    public Utilisateur(long id, String nom_utilisateur, String address_email, String mot_passe) {
        this.id = id;
        this.nom_utilisateur= nom_utilisateur;
        this.mot_passe=mot_passe;
        this.address_email = address_email;
    }
}



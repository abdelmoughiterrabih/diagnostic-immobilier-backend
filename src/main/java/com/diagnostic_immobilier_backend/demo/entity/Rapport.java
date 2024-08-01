package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rapport")
@Entity
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private String resultat_diagnostic;

    private float estimation_prix;

    private String addresse_bien;

    private String type_bien;

    private String description_bien;

    @OneToOne
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;
}

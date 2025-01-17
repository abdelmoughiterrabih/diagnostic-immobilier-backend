package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "numero de facture")
    private int numero_facture;

    private java.util.Date date_facture;

    private float montant_facture;

    private String description;
    @OneToOne
    @JoinColumn(name = "dossier_id")
    private Dossier dossier;


}

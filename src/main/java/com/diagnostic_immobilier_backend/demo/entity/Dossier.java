package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Comment;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="dossier")
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

     @NotNull(message = "numero de dossier")
    private int numero_dossier;

    private java.util.Date date_depo;

    private String nom;
    @NotNull(message = "type_service")
    private String type_service;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToOne(mappedBy = "dossier", cascade = CascadeType.ALL)
    private Rapport rapport;

    @OneToOne(mappedBy = "dossier", cascade = CascadeType.ALL)
    private Facture facture;
}

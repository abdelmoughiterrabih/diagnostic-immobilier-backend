package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Rapport")
@Entity
public class Rapport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column
    private java.util.Date date;
    @Column
    private String resultat_diagnostic;
    @Column
    private float estimation_prix;
    @Column
    private String addresse_bien;
    @Column
    private String type_bien;
    @Column
    private String description_bien;

    private boolean is_valid;

}

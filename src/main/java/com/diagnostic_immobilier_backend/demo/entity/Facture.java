package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int numero_facture;
    @Column
    private java.util.Date date_facture;
    @Column
    private float montant_facture;
    @Column
    private String description;
    public Facture(){

    }
public Facture (long id,int numero_facture,java.util.Date date_facture,float montant_facture,String description){
        this.id=id;
        this.numero_facture=numero_facture;
        this.date_facture=date_facture;
        this.montant_facture=montant_facture;
        this.description=description;
}
}

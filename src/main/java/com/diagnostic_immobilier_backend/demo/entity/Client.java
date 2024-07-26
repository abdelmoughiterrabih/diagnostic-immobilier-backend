package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String CIN;
    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private String address_email;
    @Column
    private int numero_tel;
    @Column
    private String ville ;






}

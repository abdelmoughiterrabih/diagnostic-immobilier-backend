package com.diagnostic_immobilier_backend.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "CIN")
    private String CIN;

    private String nom;

    private String prenom;

    private String address_email;

    private int numero_tel;

    private String ville ;


    public void setEmail(String mail) {
    }
}

package com.diagnostic_immobilier_backend.demo.model;

import com.diagnostic_immobilier_backend.demo.entity.Facture;
import lombok.Data;

@Data
public class FactureEmailRequest {

    private String email;
    private String objet;
    private String message;
    private Facture facture;
}

package com.diagnostic_immobilier_backend.demo.DTO;

import com.diagnostic_immobilier_backend.demo.entity.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FactureDTO {
    private Long id;
    private int numero_facture;
    private Date date_facture;
    private float montant_facture;
    private String description;
    private Long dossier;

    public static FactureDTO toDTO(Facture facture) {
        return FactureDTO.builder()
                .id(facture.getId())
                .numero_facture(facture.getNumero_facture())
                .date_facture(facture.getDate_facture())
                .montant_facture(facture.getMontant_facture())
                .description(facture.getDescription())
                .dossier(facture.getDossier() != null ? facture.getDossier().getId() : null)
                .build();
    }
}

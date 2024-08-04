package com.diagnostic_immobilier_backend.demo.DTO;
import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RapportDTO {
        private Long id;

        private Date date;

        private String resultat_diagnostic;

        private float estimation_prix;

        private String addresse_bien;

        private String type_bien;

        private String description_bien;

        private Long dossier;

        public static RapportDTO toDTO(Rapport rapport) {
            return RapportDTO.builder()
                    .id(rapport.getId())
                    .date(rapport.getDate())
                    .resultat_diagnostic(rapport.getResultat_diagnostic())
                    .estimation_prix(rapport.getEstimation_prix())
                    .addresse_bien(rapport.getAddresse_bien())
                    .type_bien(rapport.getType_bien())
                    .description_bien(rapport.getDescription_bien())
                    .dossier(rapport.getDossier()!=null?(rapport.getDossier()).getId():null)
                    .build();
        }
    }


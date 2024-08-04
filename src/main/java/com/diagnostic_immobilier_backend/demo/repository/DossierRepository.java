package com.diagnostic_immobilier_backend.demo.repository;

import com.diagnostic_immobilier_backend.demo.entity.Dossier;
import com.diagnostic_immobilier_backend.demo.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRepository extends JpaRepository<Dossier,Long> {
}

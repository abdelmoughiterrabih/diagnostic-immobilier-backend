package com.diagnostic_immobilier_backend.demo.repository;

import com.diagnostic_immobilier_backend.demo.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureRepository extends JpaRepository <Facture,Long> {

}

package com.diagnostic_immobilier_backend.demo.repository;

import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RapportRepository extends JpaRepository<Rapport,Integer> {

}

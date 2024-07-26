package com.diagnostic_immobilier_backend.demo.repository;

import com.diagnostic_immobilier_backend.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface ClientRepository extends JpaRepository<Client, Integer> {

    }


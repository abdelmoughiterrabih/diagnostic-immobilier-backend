package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Rapport;
import com.diagnostic_immobilier_backend.demo.repository.RapportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RapportService {

    @Autowired
    private RapportRepository rapportRepository;

    // Create
    public Rapport createRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    // Read
    public List<Rapport> getAllRapports() {
        return rapportRepository.findAll();
    }

    public Optional<Rapport> getRapportById(Integer id) {
        return rapportRepository.findById(id);
    }

    // Update
    public Rapport updateRapport(Rapport rapport) {
        return rapportRepository.save(rapport);
    }

    // Delete
    public void deleteRapport(Integer id) {
        rapportRepository.deleteById(id);
    }
}

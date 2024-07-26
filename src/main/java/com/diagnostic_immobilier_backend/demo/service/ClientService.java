package com.diagnostic_immobilier_backend.demo.service;

import com.diagnostic_immobilier_backend.demo.entity.Client;
import com.diagnostic_immobilier_backend.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Create
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    // Read
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(long id) {
        return clientRepository.findById((int) id);
    }

    // Update
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    // Delete
    public void deleteClient(long id) {
        clientRepository.deleteById((int) id);
    }
}
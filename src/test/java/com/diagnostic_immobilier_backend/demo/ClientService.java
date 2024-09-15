package com.diagnostic_immobilier_backend.demo;


import com.diagnostic_immobilier_backend.demo.entity.Client;
import com.diagnostic_immobilier_backend.demo.repository.ClientRepository;
import com.diagnostic_immobilier_backend.demo.service.ClientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialise les mocks
    }

    @Test
    void testCreateClient() {
        Client client = new Client();  // Crée un client fictif
        when(clientRepository.save(client)).thenReturn(client);  // Mock le comportement du repository

        Client savedClient = clientService.createClient(client);

        assertNotNull(savedClient);
        verify(clientRepository, times(1)).save(client);  // Vérifie que la méthode save a été appelée
    }

    @Test
    void testGetAllClients() {
        List<Client> clients = Arrays.asList(new Client(), new Client());  // Liste fictive de clients
        when(clientRepository.findAll()).thenReturn(clients);

        List<Client> result = clientService.getAllClients();

        assertEquals(2, result.size());
        verify(clientRepository, times(1)).findAll();  // Vérifie que findAll a été appelée
    }

    @Test
    void testGetClientById() {
        Client client = new Client();
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        Optional<Client> result = clientService.getClientById(1L);

        assertTrue(result.isPresent());
        assertEquals(client, result.get());
        verify(clientRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateClient() {
        Client client = new Client();
        when(clientRepository.save(client)).thenReturn(client);

        Client updatedClient = clientService.updateClient(client);

        assertNotNull(updatedClient);
        verify(clientRepository, times(1)).save(client);
    }

    @Test
    void testDeleteClient() {
        long clientId = 1L;
        doNothing().when(clientRepository).deleteById(clientId);

        clientService.deleteClient(clientId);

        verify(clientRepository, times(1)).deleteById(clientId);
    }
}

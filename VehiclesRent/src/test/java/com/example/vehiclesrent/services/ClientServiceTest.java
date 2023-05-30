package com.example.vehiclesrent.services;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.vehiclesrent.model.Client;
import com.example.vehiclesrent.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    
    @Mock
    private ClientRepository repo;

    @InjectMocks
    private ClientService service;

    private final List<Client> clients = new ArrayList<>();


    
}

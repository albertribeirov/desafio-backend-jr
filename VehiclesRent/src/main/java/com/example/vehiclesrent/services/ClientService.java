package com.example.vehiclesrent.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.vehiclesrent.model.Client;
import com.example.vehiclesrent.repository.ClientRepository;

public class ClientService implements ICrudService<Client>{
    
    private final ClientRepository repo;

    @Autowired
    public ClientService(ClientRepository repo) {
        this.repo = repo;
    }

    @Override
    public void delete(UUID uuid) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Client> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client getById(UUID uuid) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Client save(Client object) {
        // TODO Auto-generated method stub
        return null;
    }

    
}

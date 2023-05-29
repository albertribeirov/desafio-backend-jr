package com.example.vehiclesrent.services;

import java.util.List;
import java.util.Optional;
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
        Optional<Client> record = repo.findById(uuid);

        if (record.isPresent()) {
            repo.delete(record.get());
        }
        
        // TODO handle exception
        record.orElse(null);
    }

    @Override
    public List<Client> getAll() {
        List<Client> records = repo.findAll();
        return records;
    }

    @Override
    public Client getById(UUID uuid) {
        Optional<Client> record = repo.findById(uuid);

        if (record.isPresent()) {
            return record.get();
        }

        // TODO handle exception
        return record.orElse(null);
    }

    @Override
    public Client save(Client object) {
        return repo.save(object);
    }

    
}

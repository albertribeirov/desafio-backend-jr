package com.example.vehiclesrent.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.vehiclesrent.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{
    
    void delete(UUID uuid);
}

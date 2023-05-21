package com.example.vehiclesrent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Car extends JpaRepository<Car, UUID> {
}

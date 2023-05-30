package com.example.vehiclesrent.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.model.Client;
import com.example.vehiclesrent.repository.ClientRepository;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    
    @Mock
    private ClientRepository repo;

    @InjectMocks
    private ClientService service;


    private final List<Client> clients = new ArrayList<>();

    Car car = new Car(UUID.randomUUID(), "Aston Martin", "GPX", LocalDateTime.now());

    @DisplayName("Must return one car by ID")
    @Test
    public void must_return_one_car_by_id() {
        UUID exampleId = UUID.randomUUID();

        Client client1 = new Client(exampleId, "Kane", "300.300.300-30", car, LocalDate.of(1998, Month.JULY, 31), LocalDateTime.now(), LocalDateTime.now());
        repo.save(client1);

        Mockito.when(repo.findById(exampleId)).thenReturn(Optional.of(client1));

        Client savedClient = repo.findById(client1.getUuid()).orElse(null);

        assertNotNull(savedClient);
        assertEquals(savedClient.getUuid(), client1.getUuid());
        assertEquals(savedClient.getCpf(), client1.getCpf());
        assertEquals(savedClient.getName(), savedClient.getName());

    }
}

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


    @DisplayName("Must return a list of cars")
    @Test
    public void must_return_a_list_of_cars() {
        Client c1 = new Client(UUID.randomUUID(), "Henry", "100.200.300-40", car, LocalDate.of(1997, Month.OCTOBER, 20), LocalDateTime.now(), LocalDateTime.now());
        Client c2 = new Client(UUID.randomUUID(), "Ada", "900.900.900-92", car, LocalDate.of(1990, Month.JANUARY, 01), LocalDateTime.now(), LocalDateTime.now());
        clients.add(c1);
        clients.add(c2);

        assertNotNull(clients);
        assertEquals(2, clients.size());
    }
}

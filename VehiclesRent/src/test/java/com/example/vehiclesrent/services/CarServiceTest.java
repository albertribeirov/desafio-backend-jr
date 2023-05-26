package com.example.vehiclesrent.services;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    private Car car;

    @BeforeEach
    public void setup() {
        car.setUuid(UUID.randomUUID());
        car.setModel("Civic 2009");
        car.setBrand("Honda");
        car.setCreatedAt(LocalDateTime.now());
    }


}

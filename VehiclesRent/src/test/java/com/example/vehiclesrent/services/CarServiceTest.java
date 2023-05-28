package com.example.vehiclesrent.services;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.repository.CarRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    
    @InjectMocks
    private CarService service;
    
    // private Car car;

    // @BeforeEach
    // public void setup() {

    // }


    @DisplayName("Must return a saved car")
    @Test
    public void must_save_one_car() {
        
        Car car = new Car();
        car.setUuid(UUID.randomUUID());
        car.setModel("Civic 2009");
        car.setBrand("Honda");
        car.setCreatedAt(LocalDateTime.now());


        when(carRepository.save(car)).thenReturn(car);

        Car savedCar = service.save(car);

        assertNotNull(savedCar);
        assertEquals(car.getModel(), savedCar.getModel());
        assertEquals(car.getBrand(), savedCar.getBrand());
        assertEquals(car.getUuid(), savedCar.getUuid());


        verify(carRepository, times(1)).save(car);
    }

}

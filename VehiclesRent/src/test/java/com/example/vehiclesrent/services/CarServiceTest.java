package com.example.vehiclesrent.services;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.repository.CarRepository;

import org.assertj.core.internal.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    
    @InjectMocks
    private CarService service;

    private final List<Car> cars = new ArrayList<>();


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



    @DisplayName("Must return a list of cars from database")
    @Test
    public void must_return_list_of_cars() {

        Car car1 = new Car();
        car1.setUuid(UUID.randomUUID());
        car1.setBrand("BMW");
        car1.setModel("X6");
        car1.setCreatedAt(LocalDateTime.now());

        Car car2 = new Car();
        car2.setUuid(UUID.randomUUID());
        car2.setBrand("Aston Martin");
        car2.setModel("Vintage");
        car2.setCreatedAt(LocalDateTime.now());

        cars.add(car1);
        cars.add(car2);

        Mockito.when(carRepository.findAll()).thenReturn(cars);

        List<Car> foundCars = carRepository.findAll();

        assertNotNull(foundCars);
        assertEquals(2, foundCars.size());

        verify(carRepository, times(1)).findAll();
    }


    @DisplayName("must return one car by id from database")
    @Test
    public void must_return_one_car_by_id() {
        UUID exampleId = UUID.randomUUID();

        Car car1 = new Car(exampleId, "Aston Martin", "Vintage", LocalDateTime.now());
        carRepository.save(car1);

        Mockito.when(carRepository.findById(exampleId)).thenReturn(Optional.of(car1));

        Car foundCar = carRepository.findById(exampleId).orElse(null);

        assertNotNull(foundCar);
        assertEquals(car1.getUuid(), foundCar.getUuid());
        assertEquals(car1.getBrand(), foundCar.getBrand());
        assertEquals(car1.getModel(), foundCar.getModel());
    }


    @DisplayName("Must delete a car given its ID")
    @Test
    public void must_delete_one_car() {
        UUID exampleId = UUID.randomUUID();

        Car car1 = new Car(exampleId, "Aston Martin", "Vintage", LocalDateTime.now());
        carRepository.save(car1);

        carRepository.delete(car1.getUuid());

        Mockito.verify(carRepository, Mockito.times(1)).delete(car1.getUuid());
    }
}

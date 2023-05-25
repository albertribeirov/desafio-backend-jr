package com.example.vehiclesrent.repository;

import com.example.vehiclesrent.model.Car;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    private Car car;

    @BeforeEach
    public void setup() {
        car = new Car(UUID.randomUUID(), "Honda", "Civic Sport 2009", LocalDateTime.now());
    }

    @AfterEach
    public void end() {
        carRepository.deleteAll();
        car = null;
    }


    @Test
    void mustReturnACarSaved() {
        carRepository.save(car);
        Car carAlreadySaved = carRepository.findById(car.getUuid()).get();

        assertEquals(1, carAlreadySaved.getUuid());
    }
}

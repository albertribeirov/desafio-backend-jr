package com.example.vehiclesrent.services;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CarService implements ICrudService<Car> {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Long getAll() {
        return null;
    }

    @Override
    public List<Car> getById(UUID uuid) {
        return null;
    }

    @Override
    public Car save(Car object) {
        return null;
    }

    @Override
    public Car update(UUID uuid) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}

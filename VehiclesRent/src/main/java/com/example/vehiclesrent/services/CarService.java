package com.example.vehiclesrent.services;

import com.example.vehiclesrent.model.Car;
import com.example.vehiclesrent.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarService implements ICrudService<Car> {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAll() {
        List<Car> records = carRepository.findAll();

        return records;
    }

    @Override
    public Car getById(UUID uuid) {
        Optional<Car> record = carRepository.findById(uuid);

        if (record.isPresent()) {
            return record.get();
        }

        // TODO handling exceptions
        return record.orElse(null);
    }

    @Override
    public Car save(Car object) {
        return carRepository.save(object);
    }

    @Override
    public void delete(UUID uuid) {
        Optional<Car> record = carRepository.findById(uuid);

        if (record.isPresent()) {
            carRepository.delete(record.get());
        }
    }
}

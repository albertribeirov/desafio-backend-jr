package com.example.vehiclesrent.services;

import java.util.List;
import java.util.UUID;

public interface ICrudService<T> {

    public List<T> getAll();
    public T getById(UUID uuid);
    public T save(T object);
    public void delete(UUID uuid);
}

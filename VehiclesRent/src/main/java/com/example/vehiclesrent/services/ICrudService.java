package com.example.vehiclesrent.services;

import java.util.List;
import java.util.UUID;

public interface ICrudService<T> {

    public Long getAll();
    public List<T> getById(UUID uuid);
    public T save(T object);
    public T update(UUID uuid);
    public void delete(UUID uuid);
}
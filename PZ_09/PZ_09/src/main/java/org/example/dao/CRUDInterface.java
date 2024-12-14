package org.example.dao;

import java.util.List;

public interface CRUDInterface<T>
{
    void save(T data);
    void saveMany(List<T> data);
    void update(T data);
    void delete(T data);
    List<T> findAll();
    void deleteAll();
}

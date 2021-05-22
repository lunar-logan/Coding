package org.coding.parkinglot.dao;

import java.util.List;
import java.util.Optional;

public interface CrudOperations<T, ID> {
    T save(T entity);

    Optional<T> findById(ID id);

    List<T> findAll();

    void deleteById(ID id);

    void delete(T entity);
}

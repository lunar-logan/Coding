package org.coding.parkinglot.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class AbstractDao<T, ID> implements CrudOperations<T, ID> {
    protected final Map<ID, T> m = new ConcurrentHashMap<>();
    protected final Function<T, ID> idGetter;
    protected final BiFunction<T, ID, T> idSetter;
    protected final Supplier<ID> idSupplier;

    public AbstractDao(Function<T, ID> idGetter, BiFunction<T, ID, T> idSetter, Supplier<ID> idSupplier) {
        this.idGetter = idGetter;
        this.idSetter = idSetter;
        this.idSupplier = idSupplier;
    }

    @Override
    public T save(T entity) {
        ID id = idGetter.apply(entity);
        if (id == null) {
            id = idSupplier.get();
            entity = idSetter.apply(entity, id);
        }
        m.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(m.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(m.values());
    }

    @Override
    public void delete(T entity) {
        deleteById(idGetter.apply(entity));
    }

    @Override
    public void deleteById(ID id) {
        m.remove(id);
    }
}


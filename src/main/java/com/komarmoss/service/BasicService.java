package com.komarmoss.service;

import java.util.List;

public interface BasicService<T, ID> {
    void saveOrUpdate(T entity);

    List<T> getAll();

    T get(ID id);

    void save(T entity);

    void update(T entity);

    void remove(T entity);
}

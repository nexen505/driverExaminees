package com.komarmoss.model.dao;

import java.io.Serializable;
import java.util.List;

public interface BasicDao<T, ID extends Serializable> {
    void save(T entity);

    void saveOrUpdate(T entity);

    void update(T entity);

    void remove(T entity);

    T find(ID key);

    List<T> getAll();
}

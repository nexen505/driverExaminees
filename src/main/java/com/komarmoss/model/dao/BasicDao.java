package com.komarmoss.model.dao;

import com.komarmoss.model.entity.Identifiable;

import java.io.Serializable;
import java.util.List;

public interface BasicDao<T extends Identifiable, ID extends Serializable> {

//    String getQueryForAllObjects();

    T getItemById(final ID id);

    List<T> getItemsByIds(final List<ID> ids);

    List<T> getAllItems();

    ID saveItem(T entity);

    List<ID> saveItems(List<T> items);

    void saveOrUpdateItem(T entity);

    void updateItem(T entity);

    void removeItem(T entity);

    void removeItemById(final ID id);
}

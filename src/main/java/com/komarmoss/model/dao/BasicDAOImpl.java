package com.komarmoss.model.dao;

import com.komarmoss.model.entity.Identifiable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public abstract class BasicDAOImpl<T extends Identifiable, ID extends Serializable>
        implements BasicDAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class daoType;

    public BasicDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class getDaoType() {
        return daoType;
    }

    @Override
    public T getItemById(final ID id) {
        return id != null ? (T) entityManager.find(daoType, id) : null;
    }

    @Override
    public List<T> getItemsByIds(final List<ID> ids) {
        return ids.stream().map(this::getItemById).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public List<T> getAllItems() {
        return (List<T>) entityManager.createQuery("* from " + daoType.getSimpleName()).getResultList();
    }

    @Override
    public ID saveItem(T entity) {
        if (entity != null) {
            entityManager.persist(entity);
            return (ID) entity.getId();
        } else return null;
    }

    @Override
    public List<ID> saveItems(List<T> items) {
        if (items == null || items.isEmpty()) return Collections.emptyList();
        return items.stream().map(this::saveItem).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public void saveOrUpdateItem(T entity) {
        if (entity != null) {
            if (entity.getId() == null) saveItem(entity);
            else updateItem(entity);
        }
    }

    @Override
    public void updateItem(T entity) {
        if (entity != null) entityManager.merge(entity);
    }

    @Override
    public void removeItem(T entity) {
        if (entity != null) entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void removeItemById(final ID id) {
        if (id != null) {
            removeItem(getItemById(id));
        }
    }

}

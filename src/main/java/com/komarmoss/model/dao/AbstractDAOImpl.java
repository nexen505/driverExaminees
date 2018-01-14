package com.komarmoss.model.dao;

import com.komarmoss.model.entity.Identifiable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public abstract class AbstractDAOImpl<T extends Identifiable, ID extends Serializable>
        implements AbstractDAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class daoType;

    public AbstractDAOImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    @Override
    public T getItemById(final ID id) {
        return id != null ? (T) entityManager.find(daoType, id) : null;
    }

    @Override
    public List<T> getAllItems() {
        return (List<T>) entityManager.createQuery("select c from " + daoType.getSimpleName() + " c", daoType).getResultList();
    }

    @Override
    public ID saveItem(T entity) {
        if (entity == null) return null;
        entityManager.persist(entity);
        return (ID) entity.getId();
    }

    @Override
    public ID saveOrUpdateItem(T entity) {
        if (entity == null) return null;
        return entity.getId() == null ? saveItem(entity) : updateItem(entity);
    }

    @Override
    public ID updateItem(T entity) {
        if (entity == null) return null;
        return (ID) entityManager.merge(entity).getId();
    }

    @Override
    public void removeItem(T entity) {
        if (entity != null)
            entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public void removeItemById(final ID id) {
        if (id != null)
            removeItem(getItemById(id));
    }

}

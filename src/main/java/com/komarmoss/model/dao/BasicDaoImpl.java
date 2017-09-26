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
public abstract class BasicDaoImpl<T extends Identifiable, ID extends Serializable>
        implements BasicDao<T, ID> {

    @PersistenceContext
    EntityManager entityManager;

    protected Class daoType;

    public BasicDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void save(T entity) {
        if (entity != null) entityManager.persist(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        if (entity != null) {
            if (entity.getId() == null) save(entity);
            else update(entity);
        }
    }

    @Override
    public void update(T entity) {
        if (entity != null) entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        if (entity != null) entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }

    @Override
    public T find(ID key) {
        return key != null ? (T) entityManager.find(daoType, key) : null;
    }

    @Override
    public List<T> getAll() {
        return (List<T>) entityManager.createQuery("* from " + daoType.getSimpleName() + " t").getResultList(); //TODO check this implementation
    }
}

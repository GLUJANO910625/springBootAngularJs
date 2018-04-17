package com.example.demo3.Dao.daoImpl;

import com.example.demo3.Dao.genericDao;
import org.hibernate.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;



public class genericDaoImp<T extends Serializable, PK extends Serializable> implements genericDao<T,PK> {
    private Class<T> entityClass;

    @PersistenceContext
    private EntityManager entityManager;

    public genericDaoImp(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    @Override
    public T save(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T findById(PK id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll(T t) {
        return entityManager.createQuery("Select t from " + entityClass.getSimpleName() + " t").getResultList();
    }
}

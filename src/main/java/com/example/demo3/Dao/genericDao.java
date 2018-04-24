package com.example.demo3.Dao;


import java.io.Serializable;
import java.util.List;


public interface genericDao<T extends Serializable, PK extends Serializable> {
    public T save(T t);

    public T update(T t);

    public T findById(PK id);

    public List<T> findAll(T t);

   /* public void remove(T t);*/
}

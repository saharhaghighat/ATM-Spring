package com.atmspring.atmspring.service;

import java.util.List;

public interface GenericService<T, ID> {


    T save(T entity);

    T getById (ID id);

    List<T> getAll();

    void delete(ID id);

    void update(ID id,T entity);

}

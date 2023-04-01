package com.atmspring.atmspring.service.Impl;

import com.atmspring.atmspring.exception.NotFoundException;
import com.atmspring.atmspring.repository.GenericRepository;
import com.atmspring.atmspring.service.GenericService;
import org.yaml.snakeyaml.events.Event;
import org.yaml.snakeyaml.tokens.Token;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class GenericServiceImpl <T,ID> implements GenericService<T,ID> {

     protected abstract GenericRepository<T, ID> getRepository();



    @Override
    public T save(T entity) {
       return getRepository().save(entity);
    }

    @Override
    public T getById(ID id) {
        return getRepository().findById(id).orElseThrow(

                () -> new NotFoundException("Not found")
        );
    }

    @Override
    public List<T> getAll() {
        return getRepository().findAll();
    }

    @Override
    public void delete(ID id) {
        getById(id);
        getRepository().deleteById(id);
    }

    @Override
    public void update(ID id, T entity) {
        getById(id);
        getRepository().save(entity);
    }
}

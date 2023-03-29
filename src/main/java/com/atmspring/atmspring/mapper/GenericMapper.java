package com.atmspring.atmspring.mapper;

import java.util.List;

public interface GenericMapper <T,D>{
    T toEntity(D dto);
    D toDTO(T entity);
    List<T> toEntityList(List<D> dto);
    List<D> toDTOList(List<T> entity);

}

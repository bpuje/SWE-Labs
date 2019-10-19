package mum.edu.swe.hcmcpatientsmgmtsystem.service;

import java.util.List;

public interface BaseService<T> {

    T save(T t);

    boolean delete(Long id);

    T update(T t);

    List<T> findAll();

    T findById(Long id);

}

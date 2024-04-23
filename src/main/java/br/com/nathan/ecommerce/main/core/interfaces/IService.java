package br.com.nathan.ecommerce.main.core.interfaces;

import java.util.Set;

public interface IService<T> {
    T create(T entity);
    T update(T entity, Long id);
    T updateActive(Long id, boolean active);
    void delete(Long id);
    T findById(Long id);
    Set<T> findAll();
}

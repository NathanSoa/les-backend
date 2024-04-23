package br.com.nathan.ecommerce.main.core.interfaces;

import java.util.Set;

public interface IDAO<T> {
    T save(T entity);
    void deleteById(Long id);
    T findById(Long id);
    Set<T> findAll();
}

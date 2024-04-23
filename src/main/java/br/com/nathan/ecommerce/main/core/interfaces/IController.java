package br.com.nathan.ecommerce.main.core.interfaces;

import org.springframework.http.ResponseEntity;

public interface IController<T> {

   ResponseEntity<?> create(T dto);
   ResponseEntity<?> update(Long id, T dto);
   ResponseEntity<?> delete(Long id);
   ResponseEntity<?> findById(Long id);
   ResponseEntity<?> findAll();
   ResponseEntity<?> updateActive(Long id);
   ResponseEntity<?> updateInactive(Long id);
}

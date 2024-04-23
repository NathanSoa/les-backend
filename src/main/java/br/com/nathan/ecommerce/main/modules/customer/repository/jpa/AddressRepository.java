package br.com.nathan.ecommerce.main.modules.customer.repository.jpa;

import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}

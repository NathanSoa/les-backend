package br.com.nathan.ecommerce.main.modules.customer.repository.jpa;

import br.com.nathan.ecommerce.main.modules.customer.repository.entity.AddressPurposeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressPurposeRepository extends JpaRepository<AddressPurposeEntity, Long> {
}

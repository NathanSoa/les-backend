package br.com.nathan.ecommerce.main.modules.customer.repository.jpa;

import br.com.nathan.ecommerce.main.modules.customer.repository.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity, Long> {
}

package br.com.nathan.ecommerce.main.modules.items.repository.jpa;

import br.com.nathan.ecommerce.main.modules.items.repository.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {
}

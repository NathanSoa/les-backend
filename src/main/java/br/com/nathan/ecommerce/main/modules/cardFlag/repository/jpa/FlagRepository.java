package br.com.nathan.ecommerce.main.modules.cardFlag.repository.jpa;

import br.com.nathan.ecommerce.main.modules.cardFlag.repository.entity.FlagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlagRepository extends JpaRepository<FlagEntity, Long> {
}

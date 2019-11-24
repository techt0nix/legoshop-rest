package legoshop.dao;

import legoshop.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Дао типов деталей
 */

public interface TypeDao extends CrudRepository<Type, Long>, JpaRepository<Type, Long> {

}

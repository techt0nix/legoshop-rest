package legoshop.dao;

import legoshop.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Data access object для таблицы part_type
 */

public interface TypeDao extends CrudRepository<Type, Long>, JpaRepository<Type, Long> {

}

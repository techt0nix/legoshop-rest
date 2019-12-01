package legoshop.dao;

import legoshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Data access object для таблицы part_category
 */

public interface CategoryDao extends CrudRepository<Category, Long>, JpaRepository<Category, Long> {

}

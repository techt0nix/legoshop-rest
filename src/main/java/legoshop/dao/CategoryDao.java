package legoshop.dao;

import legoshop.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Data access object для таблицы part_category
 */

public interface CategoryDao extends CrudRepository<Category, Long>, JpaRepository<Category, Long> {

    @Query(value = "SELECT eng_name FROM part_category",  nativeQuery = true)
    List<String> getCategoriesNames();
}

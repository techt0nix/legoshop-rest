package legoshop.dao;

import legoshop.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * Data access object для таблицы color
 */

public interface ColorDao extends CrudRepository<Color, Long>, JpaRepository<Color, Long> {

    List<Color> findAll();

}

package legoshop.dao;

import legoshop.domain.Part;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Data Access Object для таблицы part
 */

public interface PartDao extends CrudRepository<Part, Long>, JpaRepository<Part, Long> {

    @Query(value = "SELECT * FROM part WHERE type_id = ?", nativeQuery = true)
    public Page<Part> findPartsByType(Long typeId, Pageable pageable);

    @Query(value = "SELECT * FROM part WHERE CONCAT(eng_name,' ', part_number) LIKE %?%", nativeQuery = true)
    public Page<Part> searchParts(String tag, Pageable pageable);

}

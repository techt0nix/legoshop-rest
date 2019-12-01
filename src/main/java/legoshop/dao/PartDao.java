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


    /**
     * Ищест совпадение в колонке eng_name или в part_number. Осуществляется засчет конкатенации этих двух колонок
     * Для добваления дополнительных колонок для поиска добавить в функцию конкатенации эту самую колонку
     *
     * @param tag - тэг, по которому будет вестись поиск
     * @param pageable - сформированный объект Pageable
     * @return
     */
    @Query(value = "SELECT * FROM part WHERE CONCAT(eng_name,' ', part_number) LIKE %?%", nativeQuery = true)
    public Page<Part> searchParts(String tag, Pageable pageable);

}

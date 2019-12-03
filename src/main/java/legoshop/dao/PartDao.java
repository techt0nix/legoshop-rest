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

    @Query(value = "SELECT * FROM part WHERE category_id = ?", nativeQuery = true)
    Page<Part> findPartsByType(Long categoryId, Pageable pageable);


    @Query(value = "SELECT * FROM part WHERE id = ?", nativeQuery = true)
    Part findPartById(Long id);


    @Query(value = "SELECT * FROM part WHERE part_number = ?", nativeQuery = true)
    Part findPartByPartNumber(String partNumber);


    /**
     * Ищет совпадение в колонке eng_name или в part_number. Осуществляется засчет конкатенации этих двух колонок
     * Для добваления дополнительных колонок для поиска добавить в функцию конкатенации эту самую колонку
     *
     * @param tag - тэг, по которому будет вестись поиск
     * @param pageable - сформированный объект Pageable
     * @return
     */
    @Query(value = "SELECT * FROM part WHERE CONCAT(eng_name,' ', part_number) LIKE %?%", nativeQuery = true)
    Page<Part> searchParts(String tag, Pageable pageable);


    @Query(value = "SELECT total_income FROM part WHERE id = ?", nativeQuery = true)
    Integer getTotalIncomeByPartId(Long id);


    @Query(value = "SELECT total_outcome FROM part WHERE id = ?", nativeQuery = true)
    Integer getTotalOutcomeByPartId(Long id);


    @Query(value = "UPDATE part SET total_income = ? WHERE id = ?", nativeQuery = true)
    void updateTotalIncomeByPartId(Integer totalIncome, Long id);


    @Query(value = "UPDATE part SET total_outcome = ? WHERE id = ?", nativeQuery = true)
    void updateTotalOutcomeByPartId(Integer totalOutcome, Long id);
}

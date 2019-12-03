package legoshop.dao;

import legoshop.domain.IncomeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IncomeItemDao extends CrudRepository<IncomeItem, Long>, JpaRepository<IncomeItem, Long> {

    @Query(value = "SELECT SUM(quantity) FROM income_item WHERE part_id = ?", nativeQuery = true)
    Integer countTotalIncomeByPartId(Long itemId);

}

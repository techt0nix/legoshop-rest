package legoshop.dao;

import legoshop.domain.OutcomeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeItemDao extends CrudRepository<OutcomeItem, Long>, JpaRepository<OutcomeItem, Long> {

    @Query(value = "SELECT SUM(quantity) FROM outcome_item WHERE item_id = ?", nativeQuery = true)
    Integer countTotalOutcomeByItemId(Long itemId);

}

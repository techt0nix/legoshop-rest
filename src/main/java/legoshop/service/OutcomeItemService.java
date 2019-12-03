package legoshop.service;

import legoshop.domain.OutcomeItem;
import java.util.Set;

public interface OutcomeItemService {

    /**
     * Подсчитывает общее количество ухода (quantity) из всех заданных OutcomeItem
     * @param outcomeItems множество OutcomeItem
     * @return общий quantity
     */
    Integer countTotalOutcome(Set<OutcomeItem> outcomeItems);


    /**
     * Подсчитывает общее количество ухода (quantity) через запрос DAO
     * @param itemId
     * @return
     */
    Integer countTotalOutcomeByPartId(Long itemId);


    void saveOutcomeItem(OutcomeItem outcomeItem);
}

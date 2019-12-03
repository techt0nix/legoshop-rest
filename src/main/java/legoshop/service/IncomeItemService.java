package legoshop.service;

import legoshop.domain.IncomeItem;
import java.util.Set;

public interface IncomeItemService {

    /**
     * Подсчитывает общее количество прихода (quantity) из всех заданных IncomeItem
     * @param incomeItems множество IncomeItem
     * @return общий quantity
     */
    Integer countTotalIncome(Set<IncomeItem> incomeItems);


    /**
     * Подсчитывает общее количество прихода (quantity) через запрос DAO
     * @param itemId
     * @return
     */
    Integer countTotalIncomeByPartId(Long itemId);


    void saveIncomeItem(IncomeItem incomeItem);
}

package legoshop.TestThings;

import legoshop.dao.IncomeDao;
import legoshop.dao.IncomeItemDao;
import legoshop.dao.OutcomeItemDao;
import legoshop.dao.PartDao;
import legoshop.domain.Income;
import legoshop.domain.IncomeItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Тестовый класс для создания Income и его IncomeItem'ов
 */

@Component
public class IncomeCreator {

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private IncomeItemDao incomeItemDao;

    @Autowired
    private OutcomeItemDao outcomeItemDao;

    @Autowired
    private PartDao partDao;


    public void createIncome() {
        Income income = new Income();

        IncomeItem incomeItem = new IncomeItem();
        int incomeItemQty = 20;
        Long itemId = 2L;

        incomeItem.setQuantity(incomeItemQty);
        incomeItem.setItem_id(itemId);
        incomeItem.setComment("first income item");

        Integer totalIncomeByPartId = countTotalIncomeByItemId(itemId);
        Integer totalOutcomeByPartId = countTotalOutcomeByItemId(itemId);

        System.out.println("total income by part id " + itemId + " = " + totalIncomeByPartId);
        System.out.println("total outcome by part_id " + itemId + " = " + totalOutcomeByPartId);
        System.out.println("total qty by part_id" + itemId + " = " + (totalIncomeByPartId - totalOutcomeByPartId));

        Set<IncomeItem> incomeItems = new HashSet<>();
        incomeItems.add(incomeItem);

        incomeItem.setIncome(income);
        income.setItems(incomeItems);
        income.setDate(new Date());
        income.setComment("first income");

        incomeDao.save(income);

        totalIncomeByPartId = countTotalIncomeByItemId(itemId);
        totalOutcomeByPartId = countTotalOutcomeByItemId(itemId);
        System.out.println("----------- after inserting");
        System.out.println("total income by part id " + itemId + " = " + totalIncomeByPartId);
        System.out.println("total outcome by part_id " + itemId + " = " + totalOutcomeByPartId);
        System.out.println("total qty by part_id" + itemId + " = " + (totalIncomeByPartId - totalOutcomeByPartId));
    }

    private Integer countTotalIncomeByItemId(Long itemId){
        Integer total = incomeItemDao.countTotalIncomeByPartId(itemId);
        return total == null ? 0 : total;
    }

    private Integer countTotalOutcomeByItemId(Long itemId){
        Integer total = outcomeItemDao.countTotalOutcomeByItemId(itemId);
        return total == null ? 0 : total;
    }
}

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
    IncomeDao incomeDao;

    @Autowired
    IncomeItemDao incomeItemDao;

    @Autowired
    OutcomeItemDao outcomeItemDao;

    @Autowired
    PartDao partDao;


    public void createIncome() {
        Income income = new Income();

        IncomeItem incomeItem = new IncomeItem();
        int incomeItemQty = 20;
        Long itemId = 2L;

        incomeItem.setQuantity(incomeItemQty);
        incomeItem.setItem_id(itemId);
        incomeItem.setComment("first income item");

        Integer totalIncomeByPartId = incomeItemDao.countTotalIncomeByPartId(itemId);

        System.out.println("total income by part id " + itemId + " = " + totalIncomeByPartId);
        System.out.println("total outcome by part_id " + itemId + " = " + outcomeItemDao.countTotalOutcomeByItemId(itemId));


        Set<IncomeItem> incomeItems = new HashSet<>();
        incomeItems.add(incomeItem);

        incomeItem.setIncome(income);
        income.setItems(incomeItems);
        income.setDate(new Date());
        income.setComment("first income");

        incomeDao.save(income);
    }

    private Integer countTotalIncomeByItemId(Long itemId){
        return incomeItemDao.countTotalIncomeByPartId(itemId);
    }

    private Integer countTotalOutcomeByItemId(Long itemId){
        return outcomeItemDao.countTotalOutcomeByItemId(itemId);
    }

}

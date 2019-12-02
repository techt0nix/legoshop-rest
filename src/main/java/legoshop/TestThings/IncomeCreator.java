package legoshop.TestThings;

import legoshop.dao.IncomeDao;
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


    public void createIncome() {
        Income income = new Income();

        IncomeItem incomeItem = new IncomeItem();

        incomeItem.setQuantity(20);
        incomeItem.setItem_id(2L);
        incomeItem.setComment("first income item");

        Set<IncomeItem> incomeItems = new HashSet<>();
        incomeItems.add(incomeItem);
        incomeItem.setIncome(income);
        income.setItems(incomeItems);

        income.setDate(new Date());
        income.setComment("first income");

        incomeDao.save(income);
    }
}

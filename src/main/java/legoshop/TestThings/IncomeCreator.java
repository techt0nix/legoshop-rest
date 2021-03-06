package legoshop.TestThings;

import legoshop.domain.*;
import legoshop.service.*;
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
    private IncomeService incomeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PartService partService;


    public void createIncome() {
        Set<IncomeItem> incomeItems = new HashSet<>();
        Long itemId = 2L;
        IncomeItem incomeItem = createIncomeItem(itemId, 100);
        incomeItems.add(incomeItem);
        Income income = prepareIncome(incomeItems);
        incomeItem.setIncome(income);
        incomeService.putIncome(income);
    }




    private IncomeItem createIncomeItem(Long itemId, Integer quantity) {
        IncomeItem incomeItem = new IncomeItem();
        Part part = partService.getPartById(itemId);
        incomeItem.setPart(part);
        incomeItem.setQuantity(quantity);
        return incomeItem;
    }

    private Income prepareIncome(Set<IncomeItem> incomeItems) {
        Income income = new Income();
        income.setItems(incomeItems);
        income.setDate(new Date());
        return income;
    }

}

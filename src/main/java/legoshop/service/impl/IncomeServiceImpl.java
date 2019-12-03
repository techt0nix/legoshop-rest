package legoshop.service.impl;

import legoshop.dao.IncomeDao;
import legoshop.domain.Income;
import legoshop.domain.IncomeItem;
import legoshop.domain.Part;
import legoshop.service.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

/**
 * Реализация сервиса Income.
 * Главный метод - putIncome.
 * Основная задача - принять сформированный Income, далее пройтись по всему его IncomeItem's, подсчитать quantity,
 * Далее запросить количество income и outcome по каждому из part и обновить значение totalQuantity в таблице part
 */

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private PartService partService;


    @Autowired
    @Qualifier("inOutSetCounter")
    private InOutCounter inOutCounter;


    @Transactional(rollbackFor = {ObjectNotFoundException.class})
    public boolean putIncome(Income income) {
        Set<IncomeItem> incomeItems = income.getItems();
        for (IncomeItem incomeItem : incomeItems) {
            Part part = incomeItem.getPart();
            Long partId = part.getId();
            Integer quantity = incomeItem.getQuantity();
            Integer currentTotalQuantity = inOutCounter.countTotalIncome(partId) - inOutCounter.countTotalOutcome(partId);
            partService.updateQuantity(part, currentTotalQuantity + quantity);
        }
        incomeDao.save(income);
        return true;
    }
}

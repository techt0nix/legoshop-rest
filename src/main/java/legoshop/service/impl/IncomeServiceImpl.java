package legoshop.service.impl;

import legoshop.dao.IncomeDao;
import legoshop.domain.Income;
import legoshop.domain.IncomeItem;
import legoshop.domain.OutcomeItem;
import legoshop.domain.Part;
import legoshop.service.IncomeItemService;
import legoshop.service.IncomeService;
import legoshop.service.OutcomeItemService;
import legoshop.service.PartService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeDao incomeDao;

    @Autowired
    private PartService partService;

    @Autowired
    private IncomeItemService incomeItemService;

    @Autowired
    private OutcomeItemService outcomeItemService;


    @Transactional(rollbackFor = {ObjectNotFoundException.class})
    public boolean putIncome(Income income) {
        Set<IncomeItem> incomeItems = income.getItems();
        for (IncomeItem incomeItem : incomeItems) {
            Part part = incomeItem.getPart();
            Long partId = part.getId();
            Integer quantity = incomeItem.getQuantity();
            Integer currentTotalQuantity = countTotalIncomeByItemId(partId) - countTotalOutcomeByItemId(partId);
            partService.updateQuantity(part, currentTotalQuantity + quantity);
        }
        incomeDao.save(income);
        return true;
    }


    private Integer countTotalIncomeByItemId(Long itemId){
        Set<IncomeItem> incomeItems = partService.getIncomeItemsById(itemId);
        return incomeItemService.countTotalIncome(incomeItems);
    }

    private Integer countTotalOutcomeByItemId(Long itemId){
        Set<OutcomeItem> outcomeItems = partService.getOutcomeItemsById(itemId);
        return outcomeItemService.countTotalOutcome(outcomeItems);
    }

}

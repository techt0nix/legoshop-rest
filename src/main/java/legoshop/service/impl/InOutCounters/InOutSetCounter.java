package legoshop.service.impl.InOutCounters;

import legoshop.domain.IncomeItem;
import legoshop.domain.OutcomeItem;
import legoshop.service.InOutCounter;
import legoshop.service.IncomeItemService;
import legoshop.service.OutcomeItemService;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

/**
 * Одна из реализацияй интерфейса InOutCounter.
 * Из базы вытаскиваются множества incomeItem или outcomeItem соответственно для конкретного part
 * Далее подсчитывается сумма
 */

@Component
public class InOutSetCounter implements InOutCounter {

    @Autowired
    private PartService partService;

    @Autowired
    private IncomeItemService incomeItemService;

    @Autowired
    private OutcomeItemService outcomeItemService;


    @Override
    public Integer countTotalIncome(Long partId) {
        Set<IncomeItem> incomeItems = partService.getIncomeItemsById(partId);
        return incomeItemService.countTotalIncome(incomeItems);
    }

    @Override
    public Integer countTotalOutcome(Long partId) {
        Set<OutcomeItem> outcomeItems = partService.getOutcomeItemsById(partId);
        return outcomeItemService.countTotalOutcome(outcomeItems);
    }
}

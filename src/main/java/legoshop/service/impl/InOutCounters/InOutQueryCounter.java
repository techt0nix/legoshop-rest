package legoshop.service.impl.InOutCounters;

import legoshop.service.InOutCounter;
import legoshop.service.IncomeItemService;
import legoshop.service.OutcomeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Одна из реализацияй интерфейса InOutCounter.
 * Подсчет ведется засчет прямого native запроса (SUM SELECT) в базу через сервис и дао соответственно
 *
 */

@Component
public class InOutQueryCounter implements InOutCounter {

    @Autowired
    private IncomeItemService incomeItemService;

    @Autowired
    private OutcomeItemService outcomeItemService;


    @Override
    public Integer countTotalIncome(Long partId) {
        return incomeItemService.countTotalIncomeByPartId(partId);
    }

    @Override
    public Integer countTotalOutcome(Long partId) {
        return outcomeItemService.countTotalOutcomeByPartId(partId);
    }
}

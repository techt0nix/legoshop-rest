package legoshop.TestThings;

import legoshop.dao.IncomeDao;
import legoshop.domain.*;
import legoshop.service.IncomeItemService;
import legoshop.service.OutcomeItemService;
import legoshop.service.PartService;
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
    private IncomeItemService incomeItemService;

    @Autowired
    private OutcomeItemService outcomeItemService;

    @Autowired
    private PartService partService;


    public void createIncome() {
        Set<IncomeItem> incomeItems = new HashSet<>();
        Long itemId = 2L;
        IncomeItem incomeItem = createIncomeItem(itemId, 20);
        incomeItems.add(incomeItem);

        Income income = prepareIncome(incomeItems);

        incomeItem.setIncome(income);

        Integer totalIncomeByPartId = countTotalIncomeByItemId(itemId);
        Integer totalOutcomeByPartId = countTotalOutcomeByItemId(itemId);

        System.out.println("total income by part id " + itemId + " = " + totalIncomeByPartId);
        System.out.println("total outcome by part_id " + itemId + " = " + totalOutcomeByPartId);
        System.out.println("total qty by part_id" + itemId + " = " + (totalIncomeByPartId - totalOutcomeByPartId));

        OutcomeItem outcomeItem = createOutcomeItem(itemId, 66, OutcomeType.SELL);
        OutcomeItem outcomeItem2 = createOutcomeItem(itemId, 21, OutcomeType.WRITE_OFF);

        incomeDao.save(income);
        outcomeItemService.saveOutcomeItem(outcomeItem);
        outcomeItemService.saveOutcomeItem(outcomeItem2);

        totalIncomeByPartId = countTotalIncomeByItemId(itemId);
        totalOutcomeByPartId = countTotalOutcomeByItemId(itemId);
        System.out.println("----------- after inserting");
        System.out.println("total income by part id " + itemId + " = " + totalIncomeByPartId);
        System.out.println("total outcome by part_id " + itemId + " = " + totalOutcomeByPartId);
        System.out.println("total qty by part_id" + itemId + " = " + (totalIncomeByPartId - totalOutcomeByPartId));
    }

    private Integer countTotalIncomeByItemId(Long itemId){
        Set<IncomeItem> incomeItems = partService.getIncomeItemsById(itemId);
        return incomeItemService.countTotalIncome(incomeItems);
    }

    private Integer countTotalOutcomeByItemId(Long itemId){
        Set<OutcomeItem> outcomeItems = partService.getOutcomeItemsById(itemId);
        return outcomeItemService.countTotalOutcome(outcomeItems);
    }

    private OutcomeItem createOutcomeItem(Long itemId, Integer quantity, OutcomeType outcomeType) {
        OutcomeItem outcomeItem = new OutcomeItem();
        Part part = partService.getPartById(itemId);
        outcomeItem.setPart(part);
        outcomeItem.setQuantity(quantity);
        outcomeItem.setOutcomeType(outcomeType);
        return outcomeItem;
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

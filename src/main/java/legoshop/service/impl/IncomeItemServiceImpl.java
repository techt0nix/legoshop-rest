package legoshop.service.impl;

import legoshop.dao.IncomeItemDao;
import legoshop.domain.IncomeItem;
import legoshop.service.IncomeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

/**
 * Реализация интерфейса IncomeItemService
 */

@Service
public class IncomeItemServiceImpl implements IncomeItemService {

    @Autowired
    private IncomeItemDao incomeItemDao;


    @Override
    public Integer countTotalIncome(Set<IncomeItem> incomeItems) {
        Integer totalCount = 0;
        for (IncomeItem incomeItem : incomeItems) {
            totalCount += incomeItem.getQuantity();
        }
        return totalCount == null ? 0 : totalCount;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer countTotalIncomeByPartId(Long itemId) {
        Integer totalCount = incomeItemDao.countTotalIncomeByPartId(itemId);
        return totalCount == null ? 0 : totalCount;
    }

    @Transactional
    @Override
    public void saveIncomeItem(IncomeItem incomeItem) {
        incomeItemDao.save(incomeItem);
    }
}

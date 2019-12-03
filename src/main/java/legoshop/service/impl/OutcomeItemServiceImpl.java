package legoshop.service.impl;

import legoshop.dao.OutcomeItemDao;
import legoshop.domain.OutcomeItem;
import legoshop.service.OutcomeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

/**
 * Реализация интерфейса OutcomeItemService
 */

@Service
public class OutcomeItemServiceImpl implements OutcomeItemService {

    @Autowired
    private OutcomeItemDao outcomeItemDao;


    @Override
    public Integer countTotalOutcome(Set<OutcomeItem> outcomeItems) {
        Integer totalCount = 0;
        for (OutcomeItem outcomeItem : outcomeItems) {
            totalCount += outcomeItem.getQuantity();
        }
        return totalCount == null ? 0 : totalCount;
    }

    @Transactional(readOnly = true)
    @Override
    public Integer countTotalOutcomeByPartId(Long itemId) {
        Integer totalCount = outcomeItemDao.countTotalOutcomeByItemId(itemId);
        return totalCount == null ? 0 : totalCount;
    }

    @Transactional
    @Override
    public void saveOutcomeItem(OutcomeItem outcomeItem) {
        outcomeItemDao.save(outcomeItem);
    }
}

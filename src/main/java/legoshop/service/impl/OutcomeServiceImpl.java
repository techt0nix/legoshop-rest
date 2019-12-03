package legoshop.service.impl;

import legoshop.dao.OutcomeDao;
import legoshop.domain.Outcome;
import legoshop.service.IncomeItemService;
import legoshop.service.OutcomeItemService;
import legoshop.service.OutcomeService;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OutcomeServiceImpl implements OutcomeService {

    @Autowired
    private OutcomeDao outcomeDao;

    @Autowired
    private PartService partService;

    @Autowired
    private IncomeItemService incomeItemService;

    @Autowired
    private OutcomeItemService outcomeItemService;


    @Override
    public boolean putOutcome(Outcome outcome) {
        return false;
    }
}

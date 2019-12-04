package legoshop.service.impl;

import legoshop.dao.OrderDao;
import legoshop.domain.Order;
import legoshop.domain.OutcomeItem;
import legoshop.domain.Part;
import legoshop.service.*;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private PartService partService;

    @Autowired
    @Qualifier("inOutSetCounter")
    private InOutCounter inOutCounter;


    @Transactional(rollbackFor = {ObjectNotFoundException.class})
    @Override
    public boolean putOrder(Order order) {
        Set<OutcomeItem> outcomeItems = order.getItems();
        for (OutcomeItem outcomeItem : outcomeItems) {
            Part part = outcomeItem.getPart();
            Long partId = part.getId();
            Integer quantity = outcomeItem.getQuantity();
            Integer currentTotalItemQuantity = inOutCounter.countTotalIncome(partId) - inOutCounter.countTotalOutcome(partId);
            System.out.println("from out: currenmt total item quantity: " + currentTotalItemQuantity);
            partService.updateQuantity(part, currentTotalItemQuantity - quantity);
        }
        orderDao.save(order);
        return true;
    }
}

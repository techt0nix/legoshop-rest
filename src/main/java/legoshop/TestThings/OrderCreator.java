package legoshop.TestThings;

import legoshop.domain.*;
import legoshop.service.IncomeService;
import legoshop.service.OrderService;
import legoshop.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
public class OrderCreator {

    @Autowired
    private IncomeService incomeService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private PartService partService;


    public void createOrder() {
        Long itemId = 2L;
        OutcomeItem outcomeItem = createOutcomeItem(itemId, 20, OutcomeType.SELL);
        Set<OutcomeItem> outcomeItems = new HashSet<>();
        outcomeItems.add(outcomeItem);
        Order order = prepareOrder(outcomeItems);
        orderService.putOrder(order);
    }

    private OutcomeItem createOutcomeItem(Long itemId, Integer quantity, OutcomeType outcomeType) {
        OutcomeItem outcomeItem = new OutcomeItem();
        Part part = partService.getPartById(itemId);
        outcomeItem.setPart(part);
        outcomeItem.setQuantity(quantity);
        outcomeItem.setOutcomeType(outcomeType);
        return outcomeItem;
    }

    private Order prepareOrder(Set<OutcomeItem> outcomeItems) {
        Order order = new Order();
        order.setItems(outcomeItems);
        order.setDate(new Date());
        order.setOrderStatus(OrderStatus.IN_PROCESS);
        order.setDeliveryIncluded(true);
        order.setDeliveryСost(250);
        return order;
    }
}

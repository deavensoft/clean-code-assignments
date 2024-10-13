package com.deavensoft.training.cleancode_solutions.naming.task1;

import com.deavensoft.training.cleancode_solutions.naming.task1.thirdpartyjar.DeliveryService;
import com.deavensoft.training.cleancode_solutions.naming.task1.thirdpartyjar.NotDeliverableOrderException;
import com.deavensoft.training.cleancode_solutions.naming.task1.thirdpartyjar.Order;
import com.deavensoft.training.cleancode_solutions.naming.task1.thirdpartyjar.OrderFulfilmentService;
import com.deavensoft.training.cleancode_solutions.naming.task1.thirdpartyjar.Product;

import java.util.List;

public class DeliveryOrderService implements OrderService {

    private DeliveryService deliveryService;
    private OrderFulfilmentService orderFulfilmentService;

    @Override
    public void submit(Order order) {
        if (deliveryService.isDeliverable()) {
            List<Product> productList = order.getProducts();
            orderFulfilmentService.fulfilProducts(productList);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService orderFulfilmentService) {
        this.orderFulfilmentService = orderFulfilmentService;
    }
}

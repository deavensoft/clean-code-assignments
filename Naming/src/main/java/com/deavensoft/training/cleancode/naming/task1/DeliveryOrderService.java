package com.deavensoft.training.cleancode.naming.task1;

import com.deavensoft.training.cleancode.naming.task1.thirdpartyjar.DeliveryService;
import com.deavensoft.training.cleancode.naming.task1.thirdpartyjar.NotDeliverableOrderException;
import com.deavensoft.training.cleancode.naming.task1.thirdpartyjar.Order;
import com.deavensoft.training.cleancode.naming.task1.thirdpartyjar.OrderFulfilmentService;
import com.deavensoft.training.cleancode.naming.task1.thirdpartyjar.Product;

import java.util.List;

public class DeliveryOrderService implements IOrderService {

    private DeliveryService mDeliveryService;

    private OrderFulfilmentService mOrderFulfilmentService;

    public void submitOrder(Order pOrder) {
        if (mDeliveryService.isDeliverable()) {
            List<Product> products = pOrder.getProducts();
            mOrderFulfilmentService.fulfilProducts(products);
        } else {
            throw new NotDeliverableOrderException();
        }
    }

    public void setDeliveryService(DeliveryService pDeliveryService) {
        this.mDeliveryService = pDeliveryService;
    }

    public void setOrderFulfilmentService(OrderFulfilmentService pOrderFulfilmentService) {
        this.mOrderFulfilmentService = pOrderFulfilmentService;
    }
}

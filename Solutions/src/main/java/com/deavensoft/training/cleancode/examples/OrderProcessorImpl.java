package com.deavensoft.training.cleancode.examples;

public class OrderProcessorImpl implements OrderProcessor {


    @Override
    // Short and concise public API method name.
    public void process(Order order) {
        if (isOrderValid(order)) {
            updateInventoryLevelsAfterProcessingOrder(order);
            sendOrderConfirmationToCustomer(order);
        }
    }

    // Longer, descriptive private method names for clarity.
    private boolean isOrderValid(Order order) {
        return hasSufficientInventoryForOrder(order) && isCustomerEligibleForOrder(order);
    }

    private boolean hasSufficientInventoryForOrder(Order order) {
        // Longer variable names for clarity in operations.
        int requiredInventoryLevel = order.getRequiredInventoryLevel();
        // Contextual variable name with short length due to clear scope and usage.
        int availableStock = getAvailableStock(order.getProduct());

        return availableStock >= requiredInventoryLevel;
    }

    private boolean isCustomerEligibleForOrder(Order order) {
        // Shortened variable name due to method context clarifying its usage.
        Customer customer = order.getCustomer();
        boolean isEligible = customer.hasValidAccount() && !customer.isInDebt();
        return isEligible;
    }

    private void updateInventoryLevelsAfterProcessingOrder(Order order) {
        // More detailed for complex scope.
        int orderQuantity = order.getQuantity();
        Product product = order.getProduct();
        reduceStock(product, orderQuantity);
    }

    private void sendOrderConfirmationToCustomer(Order order) {
        Customer customer = order.getCustomer();
        String confirmationMessage = createOrderConfirmationMessage(order);
        sendEmailToCustomer(customer, confirmationMessage);
    }

    private void reduceStock(Product product, int quantity) {
        // Example of a loop counter using a single letter variable, accepted due to its clear and minimal scope.
        for (int i = 0; i < quantity; i++) {
            // Logic to reduce stock here.
        }
    }

    private String createOrderConfirmationMessage(Order order) {
        // Method to create confirmation message.
        return "Order confirmed!";
    }

    private void sendEmailToCustomer(Customer customer, String message) {
        // Method to send email to customer.
    }

    private int getAvailableStock(Product product) {
        // Placeholder for inventory check logic.
        return 100; // Assume available stock for demonstration.
    }
}

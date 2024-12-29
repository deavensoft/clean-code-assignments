package com.deavensoft.training.cleancode.examples;

// example data class
public class Order {

    public int getRequiredInventoryLevel() {
        return 100;
    }

    public Product getProduct() {
        return new Product();
    }

    public Customer getCustomer() {
        return new Customer();
    }

    public int getQuantity() {
        return 1;
    }
}

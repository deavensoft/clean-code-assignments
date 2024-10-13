package com.deavensoft.training.cleancode.functions.task4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.deavensoft.training.cleancode.functions.task4.stubs.AvailableProductStub;
import com.deavensoft.training.cleancode.functions.task4.stubs.UnavailableProductStub;
import com.deavensoft.training.cleancode.functions.task4.thirdpartyjar.Product;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;


class OrderTest {

    private static final double DELTA = 0.0001;

    private final Order order = new Order();

    @Test
    void shouldCalculateZeroIfOrderContainsNoProduct() {
        order.setProducts(new ArrayList<>());
        assertEquals(0.0, order.getPriceOfAvailableProducts(), DELTA);
    }

    @Test
    void shouldCalculateZeroIfOrderContainsOnlyUnavailableProducts() {
        order.setProducts(getList(new UnavailableProductStub(), new UnavailableProductStub()));
        assertEquals(0.0, order.getPriceOfAvailableProducts(), DELTA);
    }

    @Test
    void shouldCalculateTwentyIfOrderContainsTwoAvailable10PriceProducts() {
        order.setProducts(getList(new AvailableProductStub(), new AvailableProductStub()));
        assertEquals(20.0, order.getPriceOfAvailableProducts(), DELTA);
    }

    @Test
    void shouldCalculateTwentyIfOrderContainsTwoAvailable10PriceProductsWithOtherUnavailableProducts() {
        order.setProducts(getList(new UnavailableProductStub(), new AvailableProductStub(),
                new AvailableProductStub(), new UnavailableProductStub()));
        assertEquals(20.0, order.getPriceOfAvailableProducts(), DELTA);
    }

    private ArrayList<Product> getList(Product... products) {
        return new ArrayList<>(Arrays.asList(products));
    }
}

package com.deavensoft.training.cleancode_solutions.functions.task4.stubs;

import com.deavensoft.training.cleancode_solutions.functions.task4.thirdpartyjar.Product;

public abstract class AbstractProductStub implements Product {
    @Override
    public double getProductPrice() {
        return 10;
    }

}

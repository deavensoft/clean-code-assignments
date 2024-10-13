package com.deavensoft.training.cleancode_solutions.naming.task4.thirdpartyjar;

public interface CustomerContactDAO {
    CustomerContact findById(Long customerId);

    void update(CustomerContact contact);
}

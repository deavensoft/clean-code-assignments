package com.deavensoft.training.cleancode.naming.task4.thirdpartyjar;

public interface CustomerContactDAO {
    CustomerContact findById(Long customerId);

    void update(CustomerContact contact);
}

package com.deavensoft.training.cleancode_solutions.naming.task4.service;


import com.deavensoft.training.cleancode_solutions.naming.task4.thirdpartyjar.CustomerContact;

public interface CustomerContactService {
    CustomerContact find(Long customerId);

    void update(CustomerContact customerContact);
}

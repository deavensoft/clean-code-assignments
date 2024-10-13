package com.deavensoft.training.cleancode_solutions.naming.task4.service.impl;


import com.deavensoft.training.cleancode_solutions.naming.task4.service.CustomerContactService;
import com.deavensoft.training.cleancode_solutions.naming.task4.thirdpartyjar.CustomerContact;
import com.deavensoft.training.cleancode_solutions.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactServiceImpl implements CustomerContactService {

    private CustomerContactDAO customerContactDAO;

    @Override
    public CustomerContact find(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    @Override
    public void update(CustomerContact customerContact) {
        customerContactDAO.update(customerContact);
    }
}

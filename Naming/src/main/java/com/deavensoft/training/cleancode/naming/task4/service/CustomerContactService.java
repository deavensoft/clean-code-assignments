package com.deavensoft.training.cleancode.naming.task4.service;


import com.deavensoft.training.cleancode.naming.task4.thirdpartyjar.CustomerContact;

public interface CustomerContactService {

    CustomerContact findCustomerContactDetailsByCustomerId(Long customerId);

    void updateCustomerContactDetails(CustomerContact customerContactDetails);

}

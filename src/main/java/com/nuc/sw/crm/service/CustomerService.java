package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> queryCustomerByUid(int uId);
}

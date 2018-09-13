package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Orders;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaticService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    CustomerRepository customerRepository;

    List<Orders> showCustomerContribution(){
    return ordersRepository.findAll();
    }


}

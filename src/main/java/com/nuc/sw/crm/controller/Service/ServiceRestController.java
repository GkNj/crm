package com.nuc.sw.crm.controller.Service;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")

public class ServiceRestController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping("/queryForCustomer")
    public List<Customer> queryForCustomer() {
        List<Customer> list = customerService.queryAll();
        return list;
    }

}

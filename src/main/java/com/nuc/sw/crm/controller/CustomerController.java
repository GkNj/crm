package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.service.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/queryCustomerByUId")
    public String queryCustomerByUId(ModelMap map){

        List<Customer> list = customerService.queryCustomerByUid(1);
        map.addAttribute("list",list);

        return "/customer/customerinfo";

    }


}

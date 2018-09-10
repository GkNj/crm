package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/statistic")
public class StaticController {
    @Autowired
    CustomerRepository repository;


    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Customer> findAllCustomer(@RequestParam("order") String arc){
        return repository.findAll();
    }
}

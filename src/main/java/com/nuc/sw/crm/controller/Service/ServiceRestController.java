package com.nuc.sw.crm.controller.Service;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.repository.UserRepository;
import com.nuc.sw.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")

public class ServiceRestController {


    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/queryForCustomer")
    public List<Customer> queryForCustomer() {
        List<Customer> list = customerService.queryAll();
        return list;
    }

    @RequestMapping("/queryForUser")
    @ResponseBody
    public List<User> queryForUser() {
        List<User> list = userRepository.findUserByPosition("AM");
        System.out.println(list);
        return list;
    }
}

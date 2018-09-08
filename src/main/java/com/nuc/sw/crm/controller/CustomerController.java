package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.service.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/queryCustomerByUId")
    public String queryCustomerByUId(ModelMap map){

        List<Customer> list = customerService.queryCustomerByUid(1);
        map.addAttribute("list",list);
        System.out.println(list);
        return "customer/customerinfo";

    }

    @RequestMapping("/queryCustomerByCId")
    public String queryCustomerByCId(ModelMap map, HttpServletRequest request){
        int id = (Integer.parseInt(request.getParameter("id"))) ;
        Customer customer = customerService.queryCustomerByCid(id);
        map.addAttribute("customer",customer);
        return "customer/linkman";
    }


}

package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.repository.CustomerRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistic")
public class StaticController {
    @Autowired
    CustomerRepository repository;
    @Autowired
    CustomerRepositoryImpl repository1;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Customer> findAllCustomer(@RequestParam("order") String arc){
        return repository.findAll();
    }

    /**
     * 按照信誉度，满意度和等级的饼形图信息
     * @return
     */
    @RequestMapping(value = "getCharts")
    @ResponseBody
    public Map getCharts(){
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("credit",repository1.findByCredit());
        map.put("ctype",repository1.findByType());
        map.put("satisfaction",repository1.findBySatisfaction());

        return map;
    }

    @RequestMapping(value = "findByService")
    @ResponseBody
    public List findByService(){
        List list = repository.findGroupByService();
       return list;
    }
}

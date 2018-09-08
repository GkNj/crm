package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/opportunity")
public class OpportunityController {

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;

    @RequestMapping(value = "/add")
    public String createOpportunity(Opportunity opportunity) {

        opportunityServiceImpl.createOpportunity(opportunity);
        return "opportunity/createopportunity";
    }

    @RequestMapping(value = "/findAll")
    public String findAllOppotuntiy(ModelMap map){
        List<Opportunity> list=new ArrayList<>();
        list=opportunityServiceImpl.findAllOpportunity();
        list.forEach(System.out::println);
        map.addAttribute("oppoList",list);
        return "opportunity/opportunitymanage";
    }

    @RequestMapping("/delete")
    public int deleteOpportunity(int id){

        opportunityServiceImpl.deleteOpportunity(id);
        return 0;
    }


}
package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/opportunity")
public class OpportunityController {

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;


    @RequestMapping(value = "/add")
    public String createOpportunity(Opportunity opportunity) {
        System.out.println("ooooo");
        opportunityServiceImpl.createOpportunity(opportunity);
        return "index";
    }
}
package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/opportunity")
public class OpportunityController {

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;
    @Autowired
    private OpprotunityRepository dao;


    @RequestMapping(value = "/add")
    public String createOpportunity(Opportunity opportunity) {

        opportunityServiceImpl.createOpportunity(opportunity);
        return "opportunity/createopportunity";
    }

    @RequestMapping(value = "/findAll")
    public List<Opportunity> findAllOppotuntiy(){
        List<Opportunity> list=new ArrayList<>();
        list=opportunityServiceImpl.findAllOpportunity();
        return list;
    }

    @RequestMapping("/delete")
    public int deleteOpportunity(int id){

        opportunityServiceImpl.deleteOpportunity(id);
        return 0;
    }

}
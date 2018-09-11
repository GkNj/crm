package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.ArrayList;
import java.util.List;

/**
 * @author superzhaolu
 */
@Controller
@RequestMapping("/opportunity")
public class OpportunityController {

    private final String BASE_URL = "opportunity/";

    private final String EDITOR = "opportunityeditor";

    private final String MANAGER = "opportunitymanage";

    private final String POINT = "opportunitypoint";

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;

    @RequestMapping(value = "/add")
    public String createOpportunity(Opportunity opportunity) {

        opportunityServiceImpl.createOpportunity(opportunity);
        return BASE_URL + MANAGER;
    }

    @RequestMapping(value = "/findAll")
    public String findAllOpportunity(ModelMap map) {
        List<Opportunity> list = opportunityServiceImpl.findAllOpportunity();
        list.forEach(System.out::println);
        map.addAttribute("oppoList", list);
        return BASE_URL + MANAGER;
    }

    @RequestMapping("/update")
    public String editor(Opportunity opportunity, ModelMap map) {
        System.out.println("opportunity editor= " + opportunity.getId() + " [" + opportunity.toString() + "], map = [" + map + "]");
        map.addAttribute("oppo", opportunity);
        return BASE_URL + EDITOR;
    }

    @RequestMapping("/modify")
    public String modify(Opportunity opportunity) {
        System.out.println("opportunity modify= [" + opportunity.toString() + " " + opportunity.getId() + "]");
        opportunityServiceImpl.modifyOpportunity(opportunity);
        return "forward:/" + BASE_URL + "findAll";
    }

    @RequestMapping("/delete")
    public String deleteOpportunity(int id) {
        System.out.println("id is " + id);
        opportunityServiceImpl.deleteOpportunity(id);
        return "forward:/" + BASE_URL + "findAll";
    }

    @RequestMapping("/findById")
    public String findOpportunityById(int id, ModelMap map) {
        Opportunity opportunity = opportunityServiceImpl.findById(id);
        map.addAttribute("oppor", opportunity);
        return BASE_URL + POINT;
    }


}
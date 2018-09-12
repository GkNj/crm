package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.repository.PlanRepository;
import com.nuc.sw.crm.service.PlanService;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
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

    private final String PLAN = "createplan";

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;
    @Autowired
    private PlanRepository planRepository;

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
        map.addAttribute("oppo", opportunity);
        return BASE_URL + EDITOR;
    }

    @RequestMapping("/modify")
    public String modify(Opportunity opportunity) {
        opportunityServiceImpl.modifyOpportunity(opportunity);
        return "forward:/" + BASE_URL + "findAll";
    }

    @RequestMapping("/delete")
    public String deleteOpportunity(int id) {
        opportunityServiceImpl.deleteOpportunity(id);
        return "forward:/" + BASE_URL + "findAll";
    }

    @RequestMapping("/findById")
    public String findOpportunityById(int id, ModelMap map) {
        Opportunity opportunity = opportunityServiceImpl.findById(id);
        map.addAttribute("oppor", opportunity);
        return BASE_URL + POINT;
    }

    @RequestMapping("/findByPId")
    public String findOpportunity( ModelMap map, HttpSession session){
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        System.out.println(user.toString());

        Opportunity opportunity=opportunityServiceImpl.findByPId(Math.toIntExact(user.getId()));

        System.out.println(opportunity.toString()+"dassssssssssssss");
        List<Exploit> exploits = planRepository.findExploitsByOId(opportunity);
        map.addAttribute("opportunity",opportunity);
        map.addAttribute("plans",exploits);

        return "opportunity/createPlan";
    }


    @RequestMapping("/point")
    public String pointOpportunity(Opportunity opportunity){
        opportunityServiceImpl.pointOpportunity(opportunity);
        System.out.println("point：："+opportunity);
        //return "redirct:option/faf"
        return "forward:/" + BASE_URL + "findAll";
    }

}
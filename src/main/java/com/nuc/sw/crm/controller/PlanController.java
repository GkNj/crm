package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.repository.LinkmanRepository;
import com.nuc.sw.crm.repository.OpportunityRepository;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import com.nuc.sw.crm.service.serviceImpl.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author superzhaolu
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
    private final String BASE_URL = "opportunity/";

    private final String PLAN = "createplan";

    private final String PLANNULL = "plannull";


    @Autowired
    private PlanServiceImpl planServiceImpl;

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;
    @Autowired
    private OpportunityRepository opportunityRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LinkmanRepository linkmanRepository;

    @RequestMapping(value = "/add")
    private String createPlan(Exploit exploit,int o_id){
        Opportunity opportunity= new Opportunity();
        opportunity.setId(o_id);
        System.out.println(o_id);
        exploit.setoId(opportunity);
        planServiceImpl.createExploit(exploit);
        return "redirect:/opportunity/findByPId";
    }

    @RequestMapping("/findall")
    private String findAllPlan(ModelMap map){
        List<Exploit> list=planServiceImpl.findAllExploit();
        map.addAttribute("plans",list);
        return "/opportunity/createplan" ;
    }

    @RequestMapping("/findopportunityById")
    public String findOpporById(int id, ModelMap map) {
        Opportunity opportunity = opportunityServiceImpl.findById(id);
        map.addAttribute("oppor", opportunity);
        return BASE_URL + PLAN;
    }

    @RequestMapping("/modify")
    private String modifyById(Exploit exploit,int oId){
        Opportunity o = new Opportunity();
        o.setId(oId);
        exploit.setoId(o);
        planServiceImpl.modifyExploit(exploit);
        return "redirect:/opportunity/findByPId";
    }

    @RequestMapping("/success")
    private String modifySuccessById(int oId){

        System.out.println("---=================================================");
        opportunityRepository.opportunitySuccess(oId);
        Opportunity o = opportunityRepository.findOpportunityById(oId);
        System.out.println("=---------------------------------------------------");

        Customer customer = new Customer();
        customer.setcName(o.getUsername());
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        customer.setuId(Math.toIntExact(user.getId()));
        System.out.println(customer.toString());
        customerRepository.save(customer);

        Customer customer1 = customerRepository.findByCName(customer.getcName());

        Linkman linkman= new Linkman();
        linkman.setcId(customer1.getcId());
        linkman.setlName(o.getlName());
        linkman.setlTel(o.getlPhone());
        System.out.println(linkman.toString());
        linkmanRepository.save(linkman);


        return BASE_URL+PLANNULL;
    }

    @RequestMapping("/fail")
    private String modifyFailById(int oId){
        opportunityRepository.opportunityFail(oId);
        return BASE_URL+PLANNULL;
    }
}

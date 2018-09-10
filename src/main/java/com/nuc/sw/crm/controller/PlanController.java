package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.service.serviceImpl.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author superzhaolu
 */
@Controller
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanServiceImpl planServiceImpl;

    @RequestMapping(value = "/add")
    private String createPlan(Exploit exploit){
        planServiceImpl.createExploit(exploit);
        return "/opportunity/createplan";
    }


}

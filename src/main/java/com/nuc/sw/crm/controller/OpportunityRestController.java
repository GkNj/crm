package com.nuc.sw.crm.controller;


import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.service.serviceImpl.OpportunityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/opportunity")
public class OpportunityRestController {



    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;



    @RequestMapping("/findByPosition")
    public List<User> findUserByPosition(){
        User user=new User();
        String position =user.setPosition("AM");
        List<User> list =opportunityServiceImpl.findUserByPosition(position);
        return list;
    }

}

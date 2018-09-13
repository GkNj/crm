package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.service.serviceImpl.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.channels.FileChannel;
import java.util.List;

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
        return "forward:/plan/findall";
    }
    @RequestMapping("/findall")
    private String findAllPlan(ModelMap map){
    System.out.println("ceshi");
        List<Exploit> list=planServiceImpl.findAllExploit();
        map.addAttribute("plans",list);
        System.out.println(list);
        return "/opportunity/createplan" ;
    }

    @RequestMapping("/findbyid")
    private  String findById(int id){
        Exploit exploit=planServiceImpl.findById(id);
        return null;
    }
    @RequestMapping("/modify")
    private String modifyById(Exploit exploit){
        planServiceImpl.modifyExploit(exploit);
        System.out.println("进入modifycontroller"+exploit);
        return "forward:/plan/findall";
    }
}

package com.nuc.sw.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/service/{path}")
    public String service(@PathVariable("path") String path) {
        return "service/" + path;
    }


    /**
     * 登录视图转跳
     *
     * @return 登录视图
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("opportunity/{path}")
    public String opportunity(@PathVariable("path")String path){
        System.out.println("执行");

        return "opportunity/"+path;

    }

}
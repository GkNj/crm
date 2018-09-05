package com.nuc.sw.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.server.PathParam;

@Controller

public class IndexController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/service/{path}")
    public String service(@PathVariable("path") String path) {
        return "service/"+path;
    }

//    @RequestMapping("/{path}")
//    public String path2Html(@PathVariable("path")String path){
//        return path;
//    }

}

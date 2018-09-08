package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.entity.Stock;
import com.nuc.sw.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {
    @Autowired
    DictionaryService service;

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Stock> findAllStock(){
        List<Stock> list = service.findAllStock();
        return list;
    }

}

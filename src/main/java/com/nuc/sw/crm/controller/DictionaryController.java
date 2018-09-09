package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    DictionaryService service;
    private String search;
    private int offset;

//    @RequestMapping(value = "/findAll")
//    @ResponseBody
//    public List<Dictionary> findAllDictionary(@RequestParam("search") String search,
//                                              @RequestParam("offset") int offset,
//                                              @RequestParam("limit") int limit,
//                                              @RequestParam("order") String order){
//        List<Dictionary> list = service.findAllDictionary();
//        Dictionary dictionary = new Dictionary();
//        dictionary.setTotal(list.size());
//        json.setRows(list);
//        return json;
//    }

    @RequestMapping(value = "/findAll1")
    @ResponseBody
    public List<Dictionary> findAllDictionary(){
        List<Dictionary> list = service.findAllDictionary();
        return list;
    }
    @RequestMapping("/addDictionary")
    public String addDictionary(@RequestParam("type") String type){
        System.out.println(type);
        return "dictionary/addDictionary";
    }
}

package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/basic")
public class DictionaryController {
    @Autowired
    DictionaryService service;


    @RequestMapping(value = "/findAllDictionary")
    public String findAllDictionary(Model model){
        List<Dictionary> list = service.findAllDictionary();
        model.addAttribute("dictionaryList",list);
        return "basic/dictionary";
    }
    @RequestMapping("/addDictionary")
    public String  addDictionary(Dictionary dictionary){
        System.out.println(dictionary);
        service.addDictionary(dictionary);
        return "redirect:/basic/findAllDictionary";
    }
  /*  @RequestMapping(value = "/updateDictionary")
    public String fupdateDiction(@RequestParam("id") int id,
                                              @RequestParam("typeKey") String key,
                                              @RequestParam("typeValue") String value,
                                              @RequestParam("parentID") int pid,
                                              @RequestParam("editable") int edit) {
        Dictionary dictionary=new Dictionary();
        dictionary.setId(id);
        dictionary.setTypeKey(key);
        dictionary.setTypeValue(value);
        dictionary.setParentID(pid);
        dictionary.setEditable(edit);
        return "redirect:basic/findAllDictionary/";
    }*/

    @RequestMapping(value = "/updateDictionary")
    public String updateDiction(Dictionary dictionary) {
        System.out.println(dictionary.toString());
//        dictionary.setId(id);
        service.updateDictionary(dictionary);
        return "redirect:/basic/findAllDictionary";
    }


    @RequestMapping(value = "/findSatifaction")
    public String findSatifaction(Model model){
        List<Dictionary> satifaction = service.findSatifaction();
        model.addAttribute("satifactionList",satifaction );
        return "redirect://";
    }

    @RequestMapping(value = "/deleteDictionary")
    public String deleteDictionary(@RequestParam("id") int id){
        System.out.println(id);
//        service.deleteDictionary(id);
//        service.deleteByParentId(id);
        service.deleteByParentId(id);
        return "redirect:/basic/findAllDictionary";
    }

//    @RequestMapping("/updateDictionary")
//    public String addDictionary(@RequestParam("type") String type){
//        System.out.println(type);
//        return "dictionary/addDictionary";
//    }
}

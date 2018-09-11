package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.Param.LinkmanParam;
import com.nuc.sw.crm.Param.TradeParam;
import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.service.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/queryCustomerByUId")
    public String queryCustomerByUId(ModelMap map,HttpServletRequest request){
        List<Customer> list = customerService.queryCustomerByUid(1);
        map.addAttribute("list",list);
        //System.out.println(list);

        return "customer/customerinfo";

    }

    @RequestMapping("/queryCustomerByCId")
    public String queryCustomerByCId(ModelMap map, HttpServletRequest request){
        int id1 = (Integer.parseInt(request.getParameter("cid"))) ;
        Customer customer = customerService.queryCustomerByCid(id1);
        List<Linkman> list = customerService.queryLinkmenByCid(id1);
        List<Trade> list1 = customerService.queryTradesByCid(id1);
        List<Orders> list2 = customerService.queryOrdersByCid(id1);
        int sum2 = customerService.countOrdersByCId(id1);
        int sum1 = customerService.countTradesByCId(id1);
        int sum = customerService.countLinkmenByCId(id1);
        map.addAttribute("customer",customer);
        map.addAttribute("linkmen",list);
        map.addAttribute("trade",list1);
        map.addAttribute("orders",list2);
        map.addAttribute("count2",sum2);
        map.addAttribute("count1",sum1);
        map.addAttribute("count",sum);
        return "customer/linkman";
    }

    @RequestMapping("/addLinkman")
    public String addLinkman(LinkmanParam linkmanParam) {
        Linkman linkman = new Linkman();
        //System.out.println(linkmanParam);
        BeanUtils.copyProperties(linkmanParam,linkman);
        customerService.addLinkman(linkman);
        return "redirect:queryCustomerByCId?id="+linkmanParam.getcId();
    }

    @RequestMapping("/addTrade")
    public String addTrade(TradeParam tradeParam) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(tradeParam,trade);
        customerService.addTrade(trade);
        return "redirect:queryCustomerByCId?id="+tradeParam.getcId();
    }

    @RequestMapping("/deleteLinkman")
    public String deleteLinkman(HttpServletRequest request) {
        int lId = Integer.parseInt(request.getParameter("lId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        customerService.deleteLinkman(lId);
        return "redirect:queryCustomerByCId?id="+cId;
    }

    @RequestMapping("/deleteTrade")
    public String deleteTrade(HttpServletRequest request) {
        int tId = Integer.parseInt(request.getParameter("tId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        customerService.deleteTrade(tId);
        return "redirect:queryCustomerByCId?id="+cId;
    }

    @RequestMapping(value = "/updateCustomer")
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:queryCustomerByCId?id="+customer.getcId();
    }

    @RequestMapping(value = "/updateLinkman")
    public String updateLinkman(Linkman linkman) {
        customerService.updateLinkman(linkman);
        return "redirect:queryCustomerByCId?id="+linkman.getcId();
    }

    @RequestMapping(value = "/updateTrade")
    public String updateTrade(Trade trade) {
        customerService.updateTrade(trade);
        return "redirect:queryCustomerByCId?id="+trade.getcId();
    }

    @RequestMapping(value = "/queryProduct")
    @ResponseBody
    public List<Product> queryProduct(int id){
//        System.out.println(id+"哈哈哈哈哈");
        List<Product> list3 = customerService.queryProduct(id);
//        System.out.println("aaaaaa"+list3);
        double total = 0;
        for(Product product:list3){
            total = total+product.getpNum()*product.getpPrice();
        }
        customerService.updatePrice(total,id);
        return list3;
    }
}

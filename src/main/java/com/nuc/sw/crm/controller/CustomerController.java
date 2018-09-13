package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.Param.LinkmanParam;
import com.nuc.sw.crm.Param.TradeParam;
import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.service.serviceImpl.CustomerServiceImpl;
import com.nuc.sw.crm.vo.LossVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.List;


@Component
@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;

    @RequestMapping("/queryCustomerByUId")
    public String queryCustomerByUId(ModelMap map) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<Customer> list = customerService.queryCustomerNotInLossByUId(Math.toIntExact(user.getId()));
        map.addAttribute("list", list);
        //System.out.println(list);

        return "customer/customerinfo";

    }

    @RequestMapping("/queryCustomerByCId")
    public String queryCustomerByCId(ModelMap map, HttpServletRequest request) {

        int id1 = (Integer.parseInt(request.getParameter("cid")));
        Customer customer = customerService.queryCustomerByCid(id1);
        List<Linkman> list = customerService.queryLinkmenByCid(id1);
        List<Trade> list1 = customerService.queryTradesByCid(id1);
        List<Orders> list2 = customerService.queryOrdersByCid(id1);
        int sum2 = customerService.countOrdersByCId(id1);
        int sum1 = customerService.countTradesByCId(id1);
        int sum = customerService.countLinkmenByCId(id1);
        map.addAttribute("customer", customer);
        map.addAttribute("linkmen", list);
        map.addAttribute("trade", list1);
        map.addAttribute("orders", list2);
        map.addAttribute("count2", sum2);
        map.addAttribute("count1", sum1);
        map.addAttribute("count", sum);
        return "customer/linkman";
    }

    @RequestMapping("/addLinkman")
    public String addLinkman(LinkmanParam linkmanParam) {
        Linkman linkman = new Linkman();
        //System.out.println(linkmanParam);
        BeanUtils.copyProperties(linkmanParam, linkman);
        customerService.addLinkman(linkman);
        return "redirect:queryCustomerByCId?cid=" + linkmanParam.getcId();
    }

    @RequestMapping("/addTrade")
    public String addTrade(TradeParam tradeParam) {
        Trade trade = new Trade();
        BeanUtils.copyProperties(tradeParam, trade);
        customerService.addTrade(trade);
        return "redirect:queryCustomerByCId?cid=" + tradeParam.getcId();
    }

    @RequestMapping("/deleteLinkman")
    public String deleteLinkman(HttpServletRequest request) {
        int lId = Integer.parseInt(request.getParameter("lId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        customerService.deleteLinkman(lId);
        return "redirect:queryCustomerByCId?cid=" + cId;
    }

    @RequestMapping("/deleteTrade")
    public String deleteTrade(HttpServletRequest request) {
        int tId = Integer.parseInt(request.getParameter("tId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        customerService.deleteTrade(tId);
        return "redirect:queryCustomerByCId?cid=" + cId;
    }

    @RequestMapping(value = "/updateCustomer")
    public String updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return "redirect:queryCustomerByCId?cid=" + customer.getcId();
    }

    @RequestMapping(value = "/updateLinkman")
    public String updateLinkman(Linkman linkman) {
        customerService.updateLinkman(linkman);
        return "redirect:queryCustomerByCId?cid=" + linkman.getcId();
    }

    @RequestMapping(value = "/updateTrade")
    public String updateTrade(Trade trade) {
        customerService.updateTrade(trade);
        return "redirect:queryCustomerByCId?cid=" + trade.getcId();
    }

    @RequestMapping(value = "/queryProduct")
    @ResponseBody
    public List<Product> queryProduct(int id) {
//        System.out.println(id+"哈哈哈哈哈");
        List<Product> list3 = customerService.queryProduct(id);
//        System.out.println("aaaaaa"+list3);
        double total = 0;
        for (Product product : list3) {
            total = total + product.getpNum() * product.getpPrice();
        }
        customerService.updatePrice(total, id);
        return list3;
    }

    //@Scheduled(cron = "0/30 * * * * ? ")
    public void orderDays() throws ParseException {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int login_id = Math.toIntExact(user.getId());
        List<Integer> integers = customerService.queryCustomerIdNotInLossByUId(login_id);
        for (int ids : integers) {
            List<Orders> list = customerService.queryOrdersByCid(ids);

            long min = 1000000;
            long i = 0;
            int c = 0;
            String a = null;
            if (list.size() != 0) {
                for (Orders orders : list) {
                    String str = orders.getoDate();
                    MyTime myTime = new MyTime();
                    i = myTime.days(str);
                    System.out.println(i);
                    System.out.println(a);
                    if (i < min) {
                        min = i;
                        a = str;
                        c = ids;
                    }
                }
            }

            //System.out.println("ade ===" + a);
            if (min > 180 && min != 100000 && a != null) {
                Loss loss = new Loss();
                loss.setoDate(a);
                loss.setcId(c);
                loss.setuId(login_id);
                loss.setlState("暂缓流失");
                //System.out.println("");
                customerService.saveLoss(loss);
            }
        }
    }

    @RequestMapping(value = "/queryLossByUId")
    public String queryLossByUId(ModelMap map) {
        List<LossVo> lossVos = customerService.queryLoss(32);
        map.addAttribute("loss", lossVos);
        return "customer/customerlost";

    }

    @RequestMapping(value = "/updateMeasure")
    public String updateMeasure(ModelMap map, HttpServletRequest request) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int log_id = Math.toIntExact(user.getId());
        int lId = Integer.parseInt(request.getParameter("lId"));
        String lMeasure = request.getParameter("lMeasure");
        String comment = request.getParameter("comment");
        String str = lMeasure + "\\" + comment;
        customerService.updateMeasure(str, lId);
        return "redirect:queryLossByUId?id=" + log_id;
    }


}

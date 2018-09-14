package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.param.LinkmanParam;
import com.nuc.sw.crm.param.TradeParam;
import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.service.serviceImpl.CustomerServiceImpl;
import com.nuc.sw.crm.vo.LossVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.*;
import java.text.ParseException;
import java.util.*;

import java.text.ParseException;
import java.util.List;



@Component
@Controller
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private CustomerRepository repository;
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


    @Scheduled(cron = "0 0 14 ? * 6 ")
    public void orderDays() throws ParseException{
        List<Integer> integers = customerService.queryCustomerIdNotInLoss();
        for (int ids:integers){
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
                if (min > 180 && min != 100000 && a!= null) {
                    Loss loss = new Loss();
                    loss.setoDate(a);
                    loss.setcId(c);
                    System.out.println("-------------------------------");
                    System.out.println("-------------------------------");
                    System.out.println("-------------------------------");
                    System.out.println("-------------------------------");
                    int uId =repository.findUIdByCId(c);
                    System.out.println(c);
                    System.out.println(uId);
                    loss.setuId(uId);
                    loss.setlState("暂缓流失");
                    //System.out.println("");
                    customerService.saveLoss(loss);
                }
            }
    }

    @RequestMapping(value = "/queryLossByUId")
    public String queryLossByUId(ModelMap map){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int log_id = Math.toIntExact(user.getId());
        List<LossVo> lossVos = customerService.queryLoss(log_id);
        map.addAttribute("loss",lossVos);
        return "customer/customerlost";
    }

    @RequestMapping(value = "/updateMeasure")

    public String updateMeasure(HttpServletRequest request){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int log_id = Math.toIntExact(user.getId());
        int lId = Integer.parseInt(request.getParameter("lId"));
        String lMeasure = request.getParameter("lMeasure");
        String comment = request.getParameter("comment");
        String str = lMeasure+"//"+comment;
        customerService.updateMeasure(str,lId);
        return "redirect:queryLossByUId?id="+ log_id;
    }

    @RequestMapping(value = "/updateReasonAndState")
    public String updateReasonAndState(HttpServletRequest request){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int log_id = Math.toIntExact(user.getId());
        int lId = Integer.parseInt(request.getParameter("l_id1"));
        String lReason = request.getParameter("comment1");
        customerService.updateReasonAndState(lReason,lId);
        return "redirect:queryLossByUId?id="+ log_id;
    }

    @RequestMapping(value="/upload")
    public String upload(@RequestParam(value="file")MultipartFile file, HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("c_id"));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int log_id = Math.toIntExact(user.getId());
        String df=new Date()+"";
        String str=df.replaceAll(" ","");
        String str1=str.replaceAll(":","");
        System.out.println(str1);
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(new File("D:\\demo\\three\\three\\crm\\src\\main\\resources\\static\\img\\"+id+str1+".jpg")));//保存图片到目录下
                out.write(file.getBytes());
                out.flush();
                out.close();
                String filename="img\\"+id+str1+".jpg";
                customerService.updatePic(filename,id);//增加用户
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败," + e.getMessage();
            }
            return "redirect:queryCustomerByUId?id="+ log_id;
        } else {
            return "上传失败，因为文件是空的.";
        }
    }



}

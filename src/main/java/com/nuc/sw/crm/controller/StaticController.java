package com.nuc.sw.crm.controller;

import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.repository.CustomerRepositoryImpl;
import com.nuc.sw.crm.repository.OrdersRepository;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/statistic")
public class StaticController {
    @Autowired
    CustomerRepository repository;
    @Autowired
    CustomerRepositoryImpl repository1;
    @Autowired
    ServiceRepository serviceRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Customer> findAllCustomer(@RequestParam("order") String arc){
        return repository.findAll();
    }

    /**
     * 按照信誉度，满意度和等级的饼形图信息
     * @return
     */
    @RequestMapping(value = "getCharts")
    @ResponseBody
    public Map getCharts(){
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("credit",repository1.findByCredit());
        map.put("ctype",repository1.findByType());
        map.put("satisfaction",repository1.findBySatisfaction());

        return map;
    }

    @RequestMapping(value = "findByService")
    @ResponseBody
    public List findByService(){
        List list = repository.findGroupByService();
       return list;
    }
    @RequestMapping(value = "findServiceByType")
    @ResponseBody
    public List<ServiceCustomer> findByServiceType(String sType, HttpSession session){
        List<ServiceCustomer> list = new ArrayList<>();
        List list1 ;
        if (sType==null||sType.equals(""))
            list1=serviceRepository.findAllSerice();
        else
           list1=serviceRepository.findServicesBySType(sType);
        for (Object o : list1){
            Object[] cells = (Object[]) o;
            ServiceCustomer c = new ServiceCustomer();
            c.setsId((Integer) cells[0]);
            c.setsType((String) cells[1]);
            c.setcName((String) cells[2]);
            list.add(c);
        }
        return list;
    }

    @RequestMapping(value = "/findByContribute")
    @ResponseBody
    public List<Contribution> findByContribute(String year,
                                               String order,
                                               String search){
        List ls;
        if (year==null||year.equals(""))
        ls= repository.findContribution();
        else
            ls=repository.findContributionByYear(year);
        List<Contribution> list = new ArrayList<>();
        for (Object o : ls){
            Object[] cells = (Object[]) o;
            Contribution c = new Contribution();
            c.setcId((Integer) cells[0]);
            c.setcName((String) cells[1]);
            c.setSum((Double) cells[2]);
            list.add(c);
        }
        return list;

    }
    @RequestMapping(value = "orderData")
    @ResponseBody
    public Map orderData(){
        List list = ordersRepository.findYearOrder();
        List list1= ordersRepository.findHasPay();
        List<String> years = new ArrayList<>();
        List x1=new ArrayList();
        List x2=new ArrayList();
        double sum=0;
        for (Object o: list){
            Object[] cells = (Object[]) o;
            years.add((String) cells[2]);
            sum= sum+(double)cells[1];
            x1.add(cells[0]);
        }
        for (Object o: list1){
            Object[] cells = (Object[]) o;
            x2.add(cells[0]);
        }

        Map map = new HashMap();
        map.put("x1",x1);
        map.put("x2",x2);
        map.put("sum",sum);
        map.put("years",years);
        return map;
    }
}

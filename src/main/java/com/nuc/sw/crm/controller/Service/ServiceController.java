package com.nuc.sw.crm.controller.Service;

import com.nuc.sw.crm.Param.ServiceParam;
import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.entity.Service;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import com.nuc.sw.crm.service.serviceImpl.ServeServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServeServiceImpl serveService;


    @RequestMapping("/add")
    public String add( ServiceParam serviceParam, ModelMap modelMap) {
        Service service = new Service();
        BeanUtils.copyProperties(serviceParam, service);
        System.out.println("add "+serviceParam.toString());
        serviceRepository.save(service);
        return "service/create.html";
    }

    @RequestMapping("/query")
    public String queryForService(ModelMap modelMap){
        List<Service> list= serveService.query();
        modelMap.addAttribute("list",list);
        System.out.println(list.toString());
        return "service/distribute";
    }

   @RequestMapping("/distribute")
    public  String distribute(HttpServletRequest req){
       String id = req.getParameter("id");
       Service service = serveService.query1(Integer.parseInt(id));
       System.out.println(service);
       service.setsState("已分配");
       int id1 = service.getsId();
       Distribute distribute=new Distribute();
       Date date=new Date();
       SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String nowtime = df.format(date);
       distribute.setdTime(nowtime);
       distribute.setsId(id1);
       distribute.setuId(1);
       serveService.addDistribute(distribute);
       serveService.save(service);
       return "redirect:/service/query";
   }


}

package com.nuc.sw.crm.controller.Service;

import com.nuc.sw.crm.param.ServiceParam;
import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.entity.Service;
import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import com.nuc.sw.crm.service.serviceImpl.ServeServiceImpl;
import com.nuc.sw.crm.vo.DistributeVo;
import com.nuc.sw.crm.vo.ServiceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping("/saveHandle")
    public String saveHandle(HttpServletRequest req) {
        String id = req.getParameter("s_Id");
        System.out.println(id);
        String uId = req.getParameter("uId");
        System.out.println("处理人id"+uId);
        Service service = serveService.query1(Integer.parseInt(id));
        System.out.println(service);
        service.setsState("已处理");
        service.setdId(Integer.parseInt(uId));
        serviceRepository.save(service);
        String request = req.getParameter("request");
        String sHandleDate = req.getParameter("sHandleDate");
        service.sethContent(request);
        service.sethResult(null);
        service.sethTime(sHandleDate);
        service.sethSatisficing(0);
        System.out.println("进入处理方法");
        serviceRepository.save(service);
        return "redirect:/service/queryForHandle";
    }

    @RequestMapping("/saveFeedBack")
    public String saveFeedBack(HttpServletRequest req) {
        String id = req.getParameter("sId");
        System.out.println(id);
        String s_result = req.getParameter("s_result");
        int satisficing = Integer.parseInt(req.getParameter("satisficing"));
        System.out.println(satisficing);
        Service service = serveService.query1(Integer.parseInt(id));
        System.out.println(service);
        if (satisficing >= 3) {
            service.sethResult(s_result);
            service.setsState("已归档");
            service.sethSatisficing(satisficing);
            serveService.save(service);
        } else {
            service.setsState("已分配");
            serveService.save(service);
        }

        return "redirect:/service/queryForFeedBack";
    }




    @RequestMapping("/queryForOk")
    @ResponseBody
    public List queryForOk(HttpServletRequest req, ModelMap map) {
        String id = req.getParameter("id");
        List<DistributeVo> list = serveService.queryHandle(Integer.parseInt(id));
        map.addAttribute("list", list);
//        System.out.println(list);
        return list;
    }

    @RequestMapping("/queryForHandle")
    public String queryForHandle(ModelMap map) {
        List<ServiceVO> list = serveService.query();
        map.addAttribute("list", list);
        System.out.println(list.toString());
        return "service/handle";
    }

    @RequestMapping("/queryForDeal")
    @ResponseBody
    public List queryForDeal(ModelMap map, HttpServletRequest req) {
        String id = req.getParameter("id");
        List<DistributeVo> list = serveService.queryHandle(Integer.parseInt(id));
        map.addAttribute("list", list);
        System.out.println(list);
        return list;

    }

    @RequestMapping("/queryForFeedBack1")
    @ResponseBody
    public List queryForFeedBack1(ModelMap map, HttpServletRequest req) {
        String id = req.getParameter("id");
        System.out.println(id);
        List<DistributeVo> list = serveService.queryForFeed(Integer.parseInt(id));
        map.addAttribute("list", list);
        System.out.println(list.toString());
        return list;
    }

    @RequestMapping("/queryForFeedBack")
    public String queryForFeedBack(ModelMap map) {
        List<ServiceVO> list = serveService.query1();
        map.addAttribute("list", list);
        System.out.println(list.toString());
        return "service/feedback";
    }

    @RequestMapping("/ok")
    public String queryForOk(ModelMap map) {
        System.out.println("进入归档方法");
        List<ServiceVO> list = serveService.query2();
        map.addAttribute("list", list);
        System.out.println(list);
        return "service/ok";
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        serveService.delete(id);
        return "forward:service/query";
    }

    @RequestMapping("/add")
    public String add(ServiceParam serviceParam) {
        Service service = new Service();
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        Long id = user.getId();
        System.out.println(user);
        System.out.println(id);
        BeanUtils.copyProperties(serviceParam, service);
        service.setuId(Math.toIntExact(id));
        System.out.println("add " + serviceParam.toString());
        System.out.println(service);
        serviceRepository.save(service);
        return "service/create";
    }

    @RequestMapping("/queryState")
    public String queryByState(ModelMap modelMap) {
        System.out.println("查询状态方法");
        List<ServiceVO> list = serveService.queryState();
        modelMap.addAttribute("list", list);
        list.forEach(System.out::println);
        return "service/distribute";
    }

    @RequestMapping("/distribute")
    public String distribute(HttpServletRequest req) {
        String id = req.getParameter("id");
        String ID= req.getParameter("ID");
        System.out.println(id);
        Service service = serveService.query1(Integer.parseInt(id));
        System.out.println(service);
        service.setsState("已分配");
        int id1 = service.getsId();
        Distribute distribute = new Distribute();
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowtime = df.format(date);
        distribute.setdTime(nowtime);
        distribute.setsId(id1);
        distribute.setuId(Integer.parseInt(ID));
        serveService.addDistribute(distribute);
        serveService.save(service);
        return "redirect:/service/queryState";

    }


}

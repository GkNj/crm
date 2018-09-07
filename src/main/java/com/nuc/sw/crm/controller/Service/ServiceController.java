package com.nuc.sw.crm.controller.Service;

import com.nuc.sw.crm.Param.ServiceParm;
import com.nuc.sw.crm.entity.Service;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/add")
    public String add(@Valid ServiceParm serviceParm, ModelMap modelMap) {
        Service service=new Service();
        BeanUtils.copyProperties(serviceParm,service);
        serviceRepository.save(service);
        return "service/create.html";
    }
}

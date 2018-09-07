package com.nuc.sw.crm.service.serviceImpl;


import com.nuc.sw.crm.repository.service.ServiceRepository;
import com.nuc.sw.crm.service.ServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServeServiceImpl implements ServeService {

    @Autowired
    private ServiceRepository serviceRepository;


    @Override
    public List<Service> query() {
        return null;
    }

}

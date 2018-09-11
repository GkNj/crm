package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Distribute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ServeService {



    List<com.nuc.sw.crm.entity.Service> query();
    com.nuc.sw.crm.entity.Service query1(int id);
    com.nuc.sw.crm.entity.Service save(com.nuc.sw.crm.entity.Service service);
    Distribute  addDistribute(Distribute distribute);
}

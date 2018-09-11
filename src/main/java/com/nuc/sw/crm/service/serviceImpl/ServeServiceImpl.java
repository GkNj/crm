package com.nuc.sw.crm.service.serviceImpl;


import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.repository.service.DistributeRepository;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import com.nuc.sw.crm.service.ServeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServeServiceImpl implements ServeService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private DistributeRepository distributeRepository;

    @Override
    public List<com.nuc.sw.crm.entity.Service> query() {
        return serviceRepository.findServiceBySState("新创建");
    }

    @Override
    public com.nuc.sw.crm.entity.Service query1(int id) {
        return serviceRepository.findServiceBySId(id);
    }

    @Override
    public com.nuc.sw.crm.entity.Service save(com.nuc.sw.crm.entity.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Distribute addDistribute(Distribute distribute) {
        return  distributeRepository.save(distribute);
    }


}

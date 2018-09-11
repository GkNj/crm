package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.repository.PlanRepository;
import com.nuc.sw.crm.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author superzhaolu
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    PlanRepository planRepository;

    @Override
    public void createExploit(Exploit exploit) {
        exploit.seteEffect("未添加");
        planRepository.save(exploit);
    }

    @Override
    public List<Exploit> finfAllExploit() {
        return null;
    }

    @Override
    public Exploit findById(int id) {
        return null;
    }

    @Override
    public Exploit modifyExploit(Exploit exploit) {
        return null;
    }

    @Override
    public void deleteExpolit(int id) {

    }
}

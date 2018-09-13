package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpportunityRepository;
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

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public void createExploit(Exploit exploit) {
        exploit.seteEffect("未添加");
        planRepository.save(exploit);
    }

    @Override
    public List<Exploit> findAllExploit() {
        List<Exploit> list =planRepository.findAll();
        return list;
    }

    @Override
    public Exploit findById(int id) {
        Exploit exploit=planRepository.findExploitByEId(id);
        return exploit;
    }

    @Override
    public void modifyExploit(Exploit exploit) {
        Exploit expl=planRepository.save(exploit);
    }

    public  void modifySuccess(Opportunity opportunity){
        opportunity.setState("开发成功");
        opportunityRepository.save(opportunity);
    }

    public  void modifyFail(Opportunity opportunity){
        opportunity.setState("开发失败");
        opportunityRepository.save(opportunity);
    }

    @Override
    public void deleteExpolit(int id) {

    }
}

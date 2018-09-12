package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.repository.UserRepository;
import com.nuc.sw.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author superzhaolu
 */
@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpprotunityRepository opprotunityRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createOpportunity(Opportunity opportunity) {
        opportunity.setState("未分配");
        opportunity.setpUsername("张三");
        opportunity.setpId("1");
        opportunity.setpDate("234");
        opprotunityRepository.save(opportunity);
    }

    @Override
    public Opportunity modifyOpportunity(Opportunity opportunity) {
        opportunity.setState("未分配");
        opportunity.setpUsername("无");
        opportunity.setpId("无");
        opportunity.setpDate("无");
        return opprotunityRepository.save(opportunity);
    }

    public void pointOpportunity(Opportunity opportunity){
        opportunity.setState("已指派");
        User user=userRepository.getOne(Long.valueOf(opportunity.getpId()));
        opportunity.setpUsername(user.getName());
        opprotunityRepository.save(opportunity);
    }
    @Override
    public void deleteOpportunity(int id) {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(id);
        opprotunityRepository.delete(opportunity);
    }

    @Override
    public List<Opportunity> findAllOpportunity() {
        List<Opportunity> list = opprotunityRepository.findOpportunitiesByState("未分配");
        return list;
    }

    @Override
    public Opportunity findById(int id) {
        Opportunity opportunity = opprotunityRepository.findOpportunityById(id);
        return opportunity;
    }

    @Override
    public List<User> findUserByPosition(String position) {
        List<User> list =userRepository.findUserByPosition(position);
        return list;
    }

}

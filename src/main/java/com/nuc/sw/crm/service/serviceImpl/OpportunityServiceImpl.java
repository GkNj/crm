package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.entity.User;
import com.nuc.sw.crm.repository.OpportunityRepository;
import com.nuc.sw.crm.repository.PlanRepository;
import com.nuc.sw.crm.repository.UserRepository;
import com.nuc.sw.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author superzhaolu
 */
@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PlanRepository planRepository;

    @Override
    public void createOpportunity(Opportunity opportunity) {
        opportunity.setState("未开发");
        opportunityRepository.save(opportunity);
    }

    @Override
    public Opportunity modifyOpportunity(Opportunity opportunity) {
        opportunity.setState("未开发");
        return opportunityRepository.save(opportunity);
    }

    public void pointOpportunity(Opportunity opportunity){
        opportunity.setState("开发中");
        User user=userRepository.getOne(Long.valueOf(opportunity.getpId()));

        opportunity.setpUsername(user.getName());
        opportunityRepository.save(opportunity);



    }
    @Override
    public void deleteOpportunity(int id) {
        Opportunity opportunity = new Opportunity();
        opportunity.setId(id);
        opportunityRepository.delete(opportunity);
    }

    @Override
    public List<Opportunity> findAllOpportunity() {
        List<Opportunity> list = opportunityRepository.findOpportunitiesByState("未开发");
        return list;
    }


    @Override
    public Opportunity findById(int id) {
        Opportunity opportunity = opportunityRepository.findOpportunityById(id);
        return opportunity;
    }

    public  Opportunity findByPId(int pid){
        Opportunity opportunity = opportunityRepository.findOpportunityByPId(pid);
        return  opportunity;
    }

    @Override
    public List<User> findUserByPosition(String position) {
        List<User> list =userRepository.findUserByPosition(position);
        return list;
    }

}

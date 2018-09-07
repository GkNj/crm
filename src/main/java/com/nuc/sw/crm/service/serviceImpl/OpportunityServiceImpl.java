package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.service.OpportunityService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    private OpprotunityRepository opprotunityRepository;

    @Override
    public int createOpportunity(Opportunity opportunity) {
        opportunity.setState("未分配");

        opprotunityRepository.save(opportunity);
        return 0;
    }

    @Override
    public List<Opportunity> modifyOpportunity(int id) {
        return null;
    }

    @Override
    public int deleteOpportunity(int id) {
        return 0;
    }

    @Override
    public List<Opportunity> selectOpportunity() {
        return null;
    }

    @Override
    public List<Opportunity> findById(int id) {
        return null;
    }
}

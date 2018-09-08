package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpprotunityRepository opprotunityRepository;

    @Override
    public void createOpportunity(Opportunity opportunity) {
        opportunity.setState("未分配");
        opportunity.setpUsername("张三");
        opportunity.setpId("1");
        opportunity.setpDate("234");
        opprotunityRepository.save(opportunity);

    }

    @Override
    public List<Opportunity> modifyOpportunity(int id) {
        List<Opportunity> list=new ArrayList<>();
        list=opprotunityRepository.findOpportunityById(id);
        return null;
    }

    @Override
    public int deleteOpportunity(int id) {
        int success=opprotunityRepository.deleteOpportunityById(id);
        if(success==0){
            System.out.println("删除失败");
            return 0;
        }else {
            System.out.println("删除成功");
            return 1;
        }

    }

    @Override
    public List<Opportunity> findAllOpportunity() {
        List<Opportunity> list=new ArrayList<>();
        list=opprotunityRepository.findOpportunitiesByState("未分配");
        return list;
    }

    @Override
    public List<Opportunity> findById(int id) {
        return null;
    }
}

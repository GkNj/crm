package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.repository.OpprotunityRepository;
import com.nuc.sw.crm.service.OpportunityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OpportunityServiceImplTest {
@Autowired
    OpportunityService opportunityService;
@Autowired
    OpprotunityRepository repository;
    @Test
    public void createOpportunity() {
//        Opportunity opportunity = new Opportunity();
//        opportunity.setpUsername("123123");
//        opportunityService.createOpportunity(opportunity);
//        repository.save(opportunity);
        }

    @Test
    public void modifyOpportunity() {
    }

    @Test
    public void deleteOpportunity() {
    }

    @Test
    public void findAllOpportunity() {
    }

    @Test
    public void findById() {
    }
}
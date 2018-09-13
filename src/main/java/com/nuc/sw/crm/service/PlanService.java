package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Exploit;

import java.util.List;

public interface PlanService {
    void createExploit(Exploit exploit);
    List<Exploit> findAllExploit();
    Exploit findById(int id);
    void modifyExploit(Exploit exploit);
    void deleteExpolit(int id);
}

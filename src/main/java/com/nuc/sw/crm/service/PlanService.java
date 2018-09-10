package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Exploit;

import java.util.List;

public interface PlanService {
    void createExploit(Exploit exploit);
    List<Exploit> finfAllExploit();
    Exploit findById(int id);
    Exploit modifyExploit(Exploit exploit);
    void deleteExpolit(int id);
}

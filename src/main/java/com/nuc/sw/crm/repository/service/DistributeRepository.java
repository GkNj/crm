package com.nuc.sw.crm.repository.service;


import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributeRepository extends JpaRepository<Distribute,Integer> {





}

package com.nuc.sw.crm.repository.service;


import com.nuc.sw.crm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {


List<Service> findServiceBySState(String state);

Service findServiceBySId(int id);


}

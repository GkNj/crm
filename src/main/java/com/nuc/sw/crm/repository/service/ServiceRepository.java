package com.nuc.sw.crm.repository.service;


import com.nuc.sw.crm.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer> {
    @Query(value = "select s_id,s_type,c_name from service,customer where service.c_id=customer.c_id;",nativeQuery =true )
    List findAllSerice();
    @Query(value = "select s_id,s_type,c_name from service,customer where service.c_id=customer.c_id and s_type=?;",nativeQuery =true )
    List findServicesBySType(String sType);





}

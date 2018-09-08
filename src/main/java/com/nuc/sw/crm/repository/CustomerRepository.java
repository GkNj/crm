package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    List<Customer> findCustomersByUId(int uId);


    @Modifying
    @Query(value = "update customer set c_address =?1,c_class =?2,c_credit =?3,c_satisfaction =?4,c_email =?5,c_post =?6,c_website =?7 where c_id =?8",nativeQuery = true)
    void updateCustomerByCId(String address,String cClass,int credit,int satisfaction,String email,String post,String website,int id);

}

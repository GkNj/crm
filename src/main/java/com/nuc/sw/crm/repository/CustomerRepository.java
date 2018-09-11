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
    @Query(value = "update customer set c_name = ?1,c_address =?2,c_class =?3,c_credit =?4,c_satisfaction =?5,c_post =?6,c_website =?7 where c_id =?8",nativeQuery = true)
    void updateCustomer(String name,String address,String cClass,int credit,int satisfaction,String post,String website,int id);

}

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

    @Query(value = "select u_id from customer where c_id = ?1",nativeQuery = true)
    int findUIdByCId(int cId);

    @Modifying
    @Query(value = "select c_id from customer where c_id not in(select c_id from loss) and u_id = ?1",nativeQuery = true)
    List<Integer> queryCustomerIdNotInLossByUId(int uId);

    @Modifying
    @Query(value = "select * from customer where c_id not in(select c_id from loss) and u_id = ?1",nativeQuery = true)
    List<Customer> queryCustomerNotInLossByUId(int uId);

    @Modifying
    @Query(value = "update customer set c_picture=?1 where c_id  = ?2",nativeQuery = true)
    int updatePic(String Pic,int id);
}

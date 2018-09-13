package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.entity.Loss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LossRepository extends JpaRepository<Loss,Integer> {

    List<Loss> findLossesByUId(int UId);

    @Modifying
    @Query(value = "select c_id from customer where c_id not in(select c_id from loss) and u_id = ?1",nativeQuery = true)
    List<Integer> queryCustomerIdNotInLossByUId(int uId);

    @Modifying
    @Query(value = "update loss set l_measure = ?1  where l_id = ?2",nativeQuery = true)
    int updateMeasure(String measure,int id);
}

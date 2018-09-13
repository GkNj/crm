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

    @Modifying
    @Query(value = "select * from loss where u_id=?1 and l_state = '暂缓流失'",nativeQuery = true)
    List<Loss> findLossesByUId(int UId);

    @Modifying
    @Query(value = "select c_id from customer where c_id not in(select c_id from loss)",nativeQuery = true)
    List<Integer> queryCustomerIdNotInLoss();

    @Modifying
    @Query(value = "update loss set l_measure = ?1  where l_id = ?2",nativeQuery = true)
    int updateMeasure(String measure,int id);

    @Modifying
    @Query(value = "update loss set u_id = ?1  where l_id = ?2",nativeQuery = true)
    int updateUId(int log_id,int id);

    @Modifying
    @Query(value = "update loss set l_reason = ?1,l_state= '已流失' where l_id = ?2",nativeQuery = true)
    int updateReasonAndState(String reason,int id);


}

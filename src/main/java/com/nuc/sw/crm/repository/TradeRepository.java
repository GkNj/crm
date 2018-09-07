package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade,Integer> {

    List<Trade> findTradesByCId(int cId);

    @Modifying
    @Query(value = "update trade set t_address =?1,t_date =?2,t_outline =?3,t_remark =?4 where t_id =?5",nativeQuery = true)
    void updateLinkmanByLId(String address,String date,String outline,String remark,int id);
}

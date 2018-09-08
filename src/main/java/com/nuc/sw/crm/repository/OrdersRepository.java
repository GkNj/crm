package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findOrdersByCId(int cId);

}

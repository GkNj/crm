package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    List<Orders> findOrdersByCId(int cId);

    int countOrdersByCId(int cId);

    Orders queryOrdersByOId(int oId);

    @Modifying
    @Query(value = "update orders set o_price=?1 where o_id =?2",nativeQuery = true)
    int updatePrice(double price,int oid);

    @Query(value = "select count(*),sum(o_price),o_date from orders group by o_date ",nativeQuery = true)
    List findYearOrder();

    @Query(value = "select count(*),o_date from orders where o_state=\"已回款\" group by o_date",nativeQuery = true)
    List findHasPay();
//    @Modifying
//    @Query(value = "insert into loss")
//    int addLost(String a,int cId,int rId);
}

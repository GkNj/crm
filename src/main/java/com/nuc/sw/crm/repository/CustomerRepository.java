package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Contribution;
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

    @Query(value = "update customer set c_address =?1,c_class =?2,c_credit =?3,c_satisfaction =?4,c_email =?5,c_post =?6,c_website =?7 where c_id =?8",nativeQuery = true)
    void updateCustomerByCId(String address,String cClass,int credit,int satisfaction,String email,String post,String website,int id);
    @Query(value = "select s_type, count(*) from service group by s_type ",nativeQuery = true)
    List findGroupByService();

    @Query(value = "select  orders.c_id cId,c_name cName,sum(o_price) sum from orders,customer where orders.c_id=customer.c_id group by orders.c_id " ,nativeQuery = true)
    List findContribution();
    @Query(value = "select orders.c_id cId,c_name cName,sum(o_price) sum from orders,customer where orders.c_id=customer.c_id and o_date=?1 group by orders.c_id " ,nativeQuery = true)
    List findContributionByYear(String data);

    @Query(value = "select c_id from customer where c_id not in(select c_id from loss) and u_id = ?1",nativeQuery = true)
    List<Integer> queryCustomerIdNotInLossByUId(int uId);

    @Modifying
    @Query(value = "select * from customer where c_id not in(select c_id from loss) and u_id = ?1",nativeQuery = true)
    List<Customer> queryCustomerNotInLossByUId(int uId);

    @Modifying
    @Query(value = "update customer set c_picture=?1 where c_id  = ?2",nativeQuery = true)
    int updatePic(String Pic,int id);
}

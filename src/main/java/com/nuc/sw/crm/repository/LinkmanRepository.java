package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Linkman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LinkmanRepository extends JpaRepository<Linkman,Integer> {

    List<Linkman> findLinkmenByCId(int cId);

    @Modifying
    @Query(value = "update linkman set l_name =?1,l_position =?2,l_sex =?3,l_tel =?4,l_remark =?5 where l_id =?6",nativeQuery = true)
    void updateLinkmanByLId(String name,String position,String sex,String tel,String remark,int id);

}

package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Opportunity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity,Integer> {


    Opportunity findOpportunityById(int id);

    List<Opportunity> findOpportunitiesByState(String state);

    int deleteOpportunityById(int id);

    Opportunity findOpportunityByPId(int pId);

    @Transactional
    @Modifying
    @Query(value = "update opportunity set opportunity.state='开发成功' where opportunity.id=?",nativeQuery = true)
    void opportunitySuccess(int id);

    @Transactional
    @Modifying
    @Query(value = "update opportunity set opportunity.state='开发失败' where opportunity.id=?",nativeQuery = true)
    void opportunityFail(int id);

}

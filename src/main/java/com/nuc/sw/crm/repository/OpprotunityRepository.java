package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Opportunity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpprotunityRepository extends JpaRepository<Opportunity,Integer> {


    List<Opportunity> findOpportunityById(int id);

    List<Opportunity> findOpportunitiesByState(String state);

    int deleteOpportunityById(int id);

}

package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Exploit;
import com.nuc.sw.crm.entity.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author superzhaolu
 */
@Repository
public interface PlanRepository extends JpaRepository<Exploit,Integer> {
    Exploit findExploitByEId(int eId);

    int deleteExploitByEId(int eId);
    List<Exploit> findExploitsByOId(Opportunity id);

}

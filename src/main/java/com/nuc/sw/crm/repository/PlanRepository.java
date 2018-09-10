package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Exploit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author superzhaolu
 */
@Repository
public interface PlanRepository extends JpaRepository<Exploit,Integer> {
    Exploit findExploitByEId(int eId);

//    List<Exploit> findExploitByState(String state);

    int deleteExploitByEId(int eId);
}

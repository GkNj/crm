package com.nuc.sw.crm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    public Map findBySatisfaction() {
        Map map = new HashMap();
//        List list = entityManager.createNativeQuery("").getSingleResult();
        Query query = entityManager.createNativeQuery("select c_satisfaction,count(*) num from customer group by c_satisfaction");
        List rows = query.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            map.put(cells[0], cells[1]);
            System.out.println("id = " + cells[0]);
            System.out.println("name = " + cells[1]);
        }

        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    public Map findByType() {
        Map map = new HashMap();
        Query query = entityManager.createNativeQuery("select c_class,count(*) num from customer group by c_class;");
        List rows = query.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            map.put(cells[0], cells[1]);
            System.out.println("id = " + cells[0]);
            System.out.println("name = " + cells[1]);
        }

        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    public Map findByCredit() {
        Map map = new HashMap();
        Query query = entityManager.createNativeQuery("select c_credit,count(*) num from customer group by c_credit;");
        List rows = query.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            map.put(cells[0], cells[1]);
            System.out.println("id = " + cells[0]);
            System.out.println("name = " + cells[1]);
        }

        return map;
    }
    @Transactional
    public Map groupByService(){
        Map map = new HashMap();
        Query query = entityManager.createNativeQuery("select s_type,count(*) num from service group by  s_type;");
        List rows = query.getResultList();
        for (Object row : rows) {
            Object[] cells = (Object[]) row;
            map.put(cells[0], cells[1]);
            System.out.println("id = " + cells[0]);
            System.out.println("name = " + cells[1]);
        }

        return map;
    }
}

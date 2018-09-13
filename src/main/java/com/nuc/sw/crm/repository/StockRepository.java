package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {
        List<Stock> findAll();


}

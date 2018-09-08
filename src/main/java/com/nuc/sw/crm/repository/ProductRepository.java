package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findProductsByOId(int oId);


}

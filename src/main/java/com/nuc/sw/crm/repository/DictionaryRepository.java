package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Integer> {
        List<Dictionary> findDictionariesByParentID(int id);
        List<Dictionary> findAll();
        List<Dictionary> findDictionaryById(int id);


}

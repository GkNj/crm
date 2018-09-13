package com.nuc.sw.crm.repository;

import com.nuc.sw.crm.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

=======
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Integer> {
        List<Dictionary> findDictionariesByParentID(int id);
        List<Dictionary> findAll();
        List<Dictionary> findDictionaryById(int id);

        List<Dictionary> findAll();
        List<Dictionary> findDictionaryById(int id);
        @Query(value = "update Dictionary set parentID=?1,typeKey=?2,typeValue=?3,editable=?4 where id=?5",nativeQuery = true)
        public String updataOne(int parentID,String typeKey,String typeValue,int editablre,int id);
        List<Dictionary> findDictionaryByParentID(int parentID);

        @Override
        void deleteById(Integer integer);

        @Modifying
        @Transactional
        @Query(value = "delete from dictionary where p_id=?1",nativeQuery = true)
        public int deleteByParentID(int id);

//        @Modifying
//        @Transactional
//        @Query(value = "select from dictionary where p_id=?1",nativeQuery = true)
//        public int findDictionariesIdByParentID(int id);



}

package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.entity.Product;
import com.nuc.sw.crm.entity.Stock;
import com.nuc.sw.crm.repository.DictionaryRepository;
import com.nuc.sw.crm.repository.ProductRepository;

import com.nuc.sw.crm.repository.StockRepository;
import com.nuc.sw.crm.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    @Autowired
    StockRepository stockRepository;

    // Dict  d = new Dic
    @Override
    public int addDictionary(Dictionary dictionary) {
        dictionaryRepository.save(dictionary);
        return 1;
    }

    @Autowired
    ProductRepository productRepository;

    // Dict  d = new Dic



    @Override
    public List<Dictionary> findAllDictionary() {
        return dictionaryRepository.findAll();
    }

    @Override
    public List<Dictionary> findSatifaction() {
        return dictionaryRepository.findDictionaryByParentID(14);
    }

    /**
     * 1.根据p_id=id查到所有一级子节点
     * 2.根据一级子节点的id查二级子节点
     *             ...(直到)
     * 4.
     */
    @Override
    public void deleteByParentId(int id) {
        List<Dictionary> ids=dictionaryRepository.findDictionaryByParentID(id);
        System.out.println(ids.toString()+"11111");
        System.out.println(id);
        deleteDictionary(id);
        if(ids.size()==0){
            System.out.println("进来了   不知道要干啥");
//            deleteDictionary(id);
            return;
        }
        for(int i=0;i<ids.size();i++){
            System.out.println(ids.toString()+i);
            System.out.println("现在用的是这个"+ids.get(i).getId());
            id=ids.get(i).getId();
            deleteByParentId(id);
        }
//        dictionaryRepository.findDictionaryByParentID(id);
//        dictionaryRepository.deleteByParentID(id);
    }

//    @Override
//    public List<Dictionary> findDictionariesIdByParentID(int id) {
//         return dictionaryRepository.findDictionaryByParentID(id);
//    }

    @Override
    public List<Stock> findAllStock() {
        return stockRepository.findAll();
    }

    @Override

    public List<Product> findAllProduct() {
        return  productRepository.findAll();
    }

    @Override

    public List<Dictionary> findById(int id) {

        return null;
    }

    @Override

    public List<Dictionary> updateDictionary(Dictionary dictionary) {

        return null;
    }

    @Override
    public int deleteDictionary(int id) {
        int i=deleteDictionary(id);
        return i;

    public Dictionary updateDictionary(Dictionary dictionary) {

        return dictionaryRepository.save(dictionary);
    }

    @Override
    public void deleteDictionary(int id) {
        dictionaryRepository.deleteById(id);
    }

    @Override
    public Dictionary addDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);

    }
}

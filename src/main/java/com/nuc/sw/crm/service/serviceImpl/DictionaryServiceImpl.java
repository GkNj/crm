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
    @Autowired
    ProductRepository productRepository;

    // Dict  d = new Dic


    @Override
    public List<Dictionary> findAllDictionary() {
        return dictionaryRepository.findAll();
    }

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
    public Dictionary updateDictionary(Dictionary dictionary) {

        return dictionaryRepository.save(dictionary);
    }

    @Override
    public int deleteDictionary(int id) {
        int i=deleteDictionary(id);
        return i;
    }

    @Override
    public Dictionary addDictionary(Dictionary dictionary) {
        return dictionaryRepository.save(dictionary);
    }
}

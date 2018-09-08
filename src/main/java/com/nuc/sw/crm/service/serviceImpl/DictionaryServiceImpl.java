package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.entity.Stock;
import com.nuc.sw.crm.repository.DictionaryRepository;
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

    @Override
    public List<Dictionary> findAllDictionary() {
        return dictionaryRepository.findAll();
    }

    @Override
    public List<Stock> findAllStock() {
        return stockRepository.findAll();
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
    }
}

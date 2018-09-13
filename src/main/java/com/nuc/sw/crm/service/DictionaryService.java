 package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Dictionary;
import com.nuc.sw.crm.entity.Product;
import com.nuc.sw.crm.entity.Stock;

import java.util.List;

public interface DictionaryService {


    /**
     * 查询所有库存信息
     * @return list
     */
    List<Stock> findAllStock();

    /**
     * 查询所有产品信息
     * @return list
     */
    List<Product> findAllProduct();

    /**
     * 根据id查询数据字典信息
     * @param id
     * @return list
     */
    List<Dictionary> findById(int id);

    /**
     * 修改数据字典信息
     * @param dictionary
     * @return list
     */
    Dictionary updateDictionary(Dictionary dictionary);

    /**
     * 删除数据字典信息
     * @param id
     */
    void deleteDictionary(int id);
    /**
     *  添加数据条目
     * @param dictionary
     * @return
     */
    Dictionary addDictionary(Dictionary dictionary);

    /**
     * 查询所有字典数据
     * @return List<dictionary>
     */
    List<Dictionary> findAllDictionary();

    /**
     * 不是到干啥的啦啦啦阿拉啦
     * @return
     */
    List<Dictionary> findSatifaction();

    /**
     * 依据父节点删除信息
     * @param id
     */
    void deleteByParentId(int id);

    /**
     * 依据父节点查询子节点的id值
     * @param id
     * @return list
     */
//    List<Dictionary> findDictionariesIdByParentID(int id);

}

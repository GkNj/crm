package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Opportunity;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;
public interface OpportunityService {
    /**
     * 创建销售机会
     * lzl
     * @param opportunity
     * @return
     */
    void createOpportunity(Opportunity opportunity);

    /**
     * 编辑销售机会
     * lzl
     * @param id
     * @return
     */
    List<Opportunity> modifyOpportunity(int id);

    /**
     * 删除销售机会
     * lzl
     * @param id
     * @return
     */
    int deleteOpportunity(int id);

    /**
     *查询所有未指派的销售机会
     * @return
     */
    List<Opportunity> findAllOpportunity();

    /**
     * 查询单个未指派的销售机会
     * @param id
     * @return
     */
    List<Opportunity> findById(int id);
}

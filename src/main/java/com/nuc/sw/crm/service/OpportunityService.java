package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Opportunity;
import com.nuc.sw.crm.entity.User;
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
     * @param opportunity
     * @return
     */
    Opportunity modifyOpportunity(Opportunity opportunity);

    /**
     * 删除销售机会
     * lzl
     * @param id
     * @return
     */
    void deleteOpportunity(int id);

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
    Opportunity findById(int id);

    /**
     * 查询客户经理
     * @param Position
     * @return
     */
    List<User> findUserByPosition(String Position);
}

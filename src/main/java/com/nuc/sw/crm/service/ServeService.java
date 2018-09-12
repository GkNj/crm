package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.vo.DistributeVo;
import com.nuc.sw.crm.vo.ServiceVO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ServeService {

    List<DistributeVo> queryHandle(int id);
    List<ServiceVO> query();
    List<ServiceVO> query1();
    List<ServiceVO> query2();
    List<DistributeVo> queryForFeed(int id);
    List<ServiceVO> queryState();
    com.nuc.sw.crm.entity.Service query1(int id);
    com.nuc.sw.crm.entity.Service save(com.nuc.sw.crm.entity.Service service);
    Distribute  addDistribute(Distribute distribute);
    int delete(int id);
}

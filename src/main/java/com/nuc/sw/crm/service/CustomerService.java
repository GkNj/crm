package com.nuc.sw.crm.service;

import com.nuc.sw.crm.entity.*;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public interface CustomerService {

    /**
     *根据客户经理id查询客户信息
     * @param uId
     * @return List
     */
    List<Customer> queryCustomerByUid(int uId);

    /**
     * 根据客户id查询单个客户信息
     * @param cId
     * @return Customer
     */
    Customer queryCustomerByCid(int cId);

    List<Customer> queryAll();

    /**
     * 根据客户id查询该客户的所有联系人
     * @param cId
     * @return List
     */
    List<Linkman> queryLinkmenByCid(int cId);

    /**
     * 根据客户id查询该客户的所有交往记录
     * @param cId
     * @return List
     */
    List<Trade> queryTradesByCid(int cId);

    /**
     * 根据客户id查询该客户的所有历史订单
     * @param cId
     * @return List
     */
    List<Orders> queryOrdersByCid(int cId);

    /**
     * 根据客户id统计历史订单总数
     * @param cId
     * @return int
     */
    int countOrdersByCId(int cId);

    /**
     * 根据客户id统计交往记录总数
     * @param cId
     * @return int
     */
    int countTradesByCId(int cId);

    /**
     * 根据客户id统计联系人总数
     * @param cId
     * @return int
     */
    int countLinkmenByCId(int cId);

    /**
     * 添加联系人
     * @param linkman
     * @return Linkman
     */
    Linkman addLinkman(Linkman linkman);

    /**
     * 添加交往记录
     * @param trade
     * @return Trade
     */
    Trade addTrade(Trade trade);

    /**
     * 删除联系人
     * @param lId
     */
    void deleteLinkman(int lId);

    /**
     * 删除交往记录
     * @param tId
     */
    void deleteTrade(int tId);

    /**
     * 通过订单id查询单个订单详情
     * @param oId
     * @return Orders
     */
    Orders queryOrdersByOId(int oId);

    /**
     * 修改客户信息
     * @param customer
     * @return Customer
     */
    Customer updateCustomer(Customer customer);

    /**
     * 修改联系人信息
     * @param linkman
     * @return Linkman
     */
    Linkman updateLinkman(Linkman linkman);

    /**
     * 修改交往记录
     * @param trade
     * @return Trade
     */
    Trade updateTrade(Trade trade);

    /**
     * 通过订单id查询产品
     * @param oId
     * @return
     */
    List<Product> queryProduct(int oId);

    /**
     * 更新订单总金额
     * @param price
     * @param oid
     * @return int
     */
    int updatePrice(double price,int oid);

    /**
     * 流失表新增
     * @param loss
     * @return LossVo
     */
    Loss saveLoss(Loss loss);

    List<Loss> queryLossByUId(int uid);

    List<Integer> queryCustomerIdNotInLoss();


    List<Customer> queryCustomerNotInLossByUId(int uId);

    int updateMeasure(String measure,int id);

    int updateReasonAndState(String reason,int id);

    int updatePic(String Pic,int id);

    int updateUId(int log_id,int id);
}

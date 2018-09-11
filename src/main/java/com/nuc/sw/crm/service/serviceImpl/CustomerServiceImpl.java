package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.repository.*;
import com.nuc.sw.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private LinkmanRepository linkmanRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Customer> queryCustomerByUid(int uId) {

        return customerRepository.findCustomersByUId(uId);
    }

    @Override
    public Customer queryCustomerByCid(int cId) {


        return customerRepository.getOne(cId);
    }

    public List<Customer> queryAll() {
        return customerRepository.findAll();

    }

    @Override
    public List<Linkman> queryLinkmenByCid(int cId) {

        return linkmanRepository.findLinkmenByCId(cId);
    }

    @Override
    public List<Trade> queryTradesByCid(int cId) {

        return tradeRepository.findTradesByCId(cId);
    }

    @Override
    public List<Orders> queryOrdersByCid(int cId) {

        return ordersRepository.findOrdersByCId(cId);
    }

    @Override
    public int countOrdersByCId(int cId) {

        return ordersRepository.countOrdersByCId(cId);
    }

    @Override
    public int countTradesByCId(int cId) {

        return tradeRepository.countTradesByCId(cId);
    }

    @Override
    public int countLinkmenByCId(int cId) {

        return linkmanRepository.countLinkmenByCId(cId);
    }

    @Override
    public Linkman addLinkman(Linkman linkman) {

        return linkmanRepository.save(linkman);
    }

    @Override
    public Trade addTrade(Trade trade) {

        return tradeRepository.save(trade);
    }

    @Override
    public void deleteLinkman(int lId) {

        linkmanRepository.deleteById(lId);
    }

    @Override
    public void deleteTrade(int tId) {

        tradeRepository.deleteById(tId);
    }

    @Override
    public Orders queryOrdersByOId(int oId) {

        return ordersRepository.queryOrdersByOId(oId);
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Linkman updateLinkman(Linkman linkman) {

        return linkmanRepository.save(linkman);
    }

    @Override
    public Trade updateTrade(Trade trade) {

        return tradeRepository.save(trade);
    }

    @Override
    public List<Product> queryProduct(int oId) {

        return productRepository.findProductsByOId(oId);
    }

//    @Override
//    public Orders savePrice(Orders orders) {
//
//        return ordersRepository.save(orders);
//    }


    @Override
    public int updatePrice(double price, int oid) {

        return ordersRepository.updatePrice(price,oid);
    }
}

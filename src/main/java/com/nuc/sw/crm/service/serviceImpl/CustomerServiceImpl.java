package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.*;
import com.nuc.sw.crm.repository.*;
import com.nuc.sw.crm.service.CustomerService;
import com.nuc.sw.crm.vo.LossVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    @Autowired
    private LossRepository lossRepository;
    @Autowired
    private UserRepository userRepository;

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

    @Override
    public int updatePrice(double price, int oid) {

        return ordersRepository.updatePrice(price,oid);
    }

    @Override
    public Loss saveLoss(Loss loss) {

        return lossRepository.save(loss);
    }

    @Override
    public List<Loss> queryLossByUId(int uid) {

        return lossRepository.findLossesByUId(uid);
    }

    @Override
    public List<Integer> queryCustomerIdNotInLoss() {

        return lossRepository.queryCustomerIdNotInLoss();
    }

    @Override
    public List<Customer> queryCustomerNotInLossByUId(int uId) {

        return customerRepository.queryCustomerNotInLossByUId(uId);
    }

    private List LossQuery(List<Loss> losses) {
        Stream<LossVo> lossVOStream = losses.stream().map(i -> {
            LossVo lossVo = new LossVo();
            BeanUtils.copyProperties(i, lossVo);
            lossVo.setCustomer(customerRepository.getOne(i.getcId()));
            lossVo.setUser(userRepository.getOne(Integer.toUnsignedLong(i.getuId())));
            return lossVo;
        });
        List<LossVo> list = lossVOStream.collect(Collectors.toList());
        System.out.println(list);
        return list;
    }


    public List<LossVo> queryLoss(int id) {
        List<Loss> losses = lossRepository.findLossesByUId(id);
        List list = LossQuery(losses);
        return list;
    }

    @Override
    public int updateMeasure(String measure, int id) {

        return lossRepository.updateMeasure(measure,id);
    }

    @Override
    public int updateReasonAndState(String reason, int id) {

        return lossRepository.updateReasonAndState(reason,id);
    }

    @Override
    public int updatePic(String Pic, int id){

        return customerRepository.updatePic(Pic,id);
    }

    @Override
    public int updateUId(int log_id, int id) {

        return lossRepository.updateUId(log_id,id);
    }
}

package com.nuc.sw.crm.service.serviceImpl;


import com.nuc.sw.crm.entity.Distribute;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.repository.UserRepository;
import com.nuc.sw.crm.repository.service.DistributeRepository;
import com.nuc.sw.crm.repository.service.ServiceRepository;
import com.nuc.sw.crm.service.ServeService;
import com.nuc.sw.crm.vo.DistributeVo;
import com.nuc.sw.crm.vo.ServiceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServeServiceImpl implements ServeService {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private DistributeRepository distributeRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private UserRepository userRepository;

    private List connectQuery(List<com.nuc.sw.crm.entity.Service> services) {
        Stream<ServiceVO> serviceVOStream = services.stream().map(i -> {
            ServiceVO serviceVO = new ServiceVO();
            BeanUtils.copyProperties(i, serviceVO);
            serviceVO.setCustomer(customerRepository.getOne(i.getcId()));
            serviceVO.setUser(userRepository.getOne(Integer.toUnsignedLong(i.getuId())));
            return serviceVO;
        });
        List<ServiceVO> list = serviceVOStream.collect(Collectors.toList());

        return list;
    }

    private List DistributeQuery(List<Distribute> distributes) {
        Stream<DistributeVo> serviceVOStream = distributes.stream().map(i -> {
            DistributeVo distributeVo = new DistributeVo();
            ServiceVO serviceVO=new ServiceVO();
            BeanUtils.copyProperties(i, distributeVo);
            com.nuc.sw.crm.entity.Service service = serviceRepository.getOne(i.getsId());
            BeanUtils.copyProperties(serviceRepository.getOne(i.getsId()),serviceVO);
            serviceVO.setUser(userRepository.getOne((long) i.getuId()));
            serviceVO.setCustomer(customerRepository.getOne(service.getcId()));
            distributeVo.setService(serviceVO);
            distributeVo.setUser(userRepository.getOne((long) i.getuId()));
            return distributeVo;
        });
        List<DistributeVo> list = serviceVOStream.collect(Collectors.toList());

        return list;
    }

    @Override
    public List<DistributeVo> queryHandle(int id) {
        List<Distribute> distributes = distributeRepository.findDistributeBySId(id);
        List list = DistributeQuery(distributes);
        return list;
    }

    @Override
    public List<ServiceVO> query() {
        List<com.nuc.sw.crm.entity.Service> services = serviceRepository.findServiceBySState("已分配");
        List list = connectQuery(services);
        return list;
    }
    @Override
    public List<ServiceVO> query1() {
        List<com.nuc.sw.crm.entity.Service> services = serviceRepository.findServiceBySState("已处理");
        List list = connectQuery(services);
        return list;
    }
    @Override
    public List<ServiceVO> query2() {
        List<com.nuc.sw.crm.entity.Service> services = serviceRepository.findServiceBySState("已归档");
        List list = connectQuery(services);
        return list;
    }
    @Override
    public List<DistributeVo> queryForFeed(int id) {
        List<com.nuc.sw.crm.entity.Distribute> services = distributeRepository.findDistributeBySId(id);
        List list = DistributeQuery(services);
        return list;
    }

    @Override
    public List<ServiceVO> queryState() {
        List<com.nuc.sw.crm.entity.Service> services = serviceRepository.findServiceBySState("新创建");
        List list = connectQuery(services);
        return list;
    }


    @Override
    public com.nuc.sw.crm.entity.Service query1(int id) {
        return serviceRepository.findServiceBySId(id);
    }

    @Override
    public com.nuc.sw.crm.entity.Service save(com.nuc.sw.crm.entity.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Distribute addDistribute(Distribute distribute) {
        return distributeRepository.save(distribute);
    }

    @Override
    public int delete(int id) {
        return serviceRepository.deleteServiceBySId(id);
    }


}

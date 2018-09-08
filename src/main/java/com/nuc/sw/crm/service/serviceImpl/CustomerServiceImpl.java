package com.nuc.sw.crm.service.serviceImpl;

import com.nuc.sw.crm.entity.Customer;
import com.nuc.sw.crm.repository.CustomerRepository;
import com.nuc.sw.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> queryCustomerByUid(int uId) {

        return customerRepository.findCustomersByUId(uId);
    }

    @Override
    public Customer queryCustomerByCid(int cId) {
        return customerRepository.getOne(cId);

    public List<Customer> queryAll() {
        return customerRepository.findAll();

    }


}

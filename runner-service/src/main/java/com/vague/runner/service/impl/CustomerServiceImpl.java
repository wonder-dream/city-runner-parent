package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.mapper.CustomerMapper;
import com.vague.runner.model.entity.Customer;
import com.vague.runner.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {
    @Override
    public void createCustomerProfile(Long id) {
        Customer customer = new Customer();
        customer.setId(id);
        baseMapper.insert(customer);
    }
}

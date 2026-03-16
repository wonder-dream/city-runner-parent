package com.vague.runner.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.vague.runner.model.entity.Customer;

public interface CustomerService extends IService<Customer> {
    void createCustomerProfile(Long id);
}

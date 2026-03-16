package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.mapper.AddressMapper;
import com.vague.runner.service.AddressService;
import org.springframework.stereotype.Service;
import com.vague.runner.model.entity.Address;

@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements AddressService {
}

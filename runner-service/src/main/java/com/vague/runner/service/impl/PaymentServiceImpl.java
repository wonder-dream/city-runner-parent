package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.mapper.PaymentMapper;
import com.vague.runner.model.entity.Payment;
import com.vague.runner.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
}

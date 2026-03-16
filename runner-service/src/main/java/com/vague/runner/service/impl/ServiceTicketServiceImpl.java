package com.vague.runner.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vague.runner.mapper.ServiceTicketMapper;
import com.vague.runner.model.entity.ServiceTicket;
import com.vague.runner.service.ServiceTicketService;
import org.springframework.stereotype.Service;

@Service
public class ServiceTicketServiceImpl extends ServiceImpl<ServiceTicketMapper, ServiceTicket> implements ServiceTicketService {
}

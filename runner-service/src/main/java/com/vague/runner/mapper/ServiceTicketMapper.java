package com.vague.runner.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.vague.runner.model.entity.ServiceTicket;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ServiceTicketMapper extends BaseMapper<ServiceTicket> {
}
